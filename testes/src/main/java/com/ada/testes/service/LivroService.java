package com.ada.testes.service;

import com.ada.testes.dto.in.LivroCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.entity.LivroEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.LivroRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final ObjectMapper objectMapper;

    public LivroDTO cadastrarLivro(LivroCreateDTO livroCreateDTO) {
        LivroEntity livroEntity = objectMapper.convertValue(livroCreateDTO, LivroEntity.class);
        livroEntity = livroRepository.save(livroEntity);
        return objectMapper.convertValue(livroEntity, LivroDTO.class);
    }

    public LivroDTO editarLivro(Integer idLivro, LivroCreateDTO livroCreateDTO) throws RegraDeNegocioException {
        LivroEntity livroEncontrado = buscarLivroPorId(idLivro);
        // é permitido alterar todos os campos de livro exceto o ID
        livroEncontrado.setNome(livroCreateDTO.getNome());
        livroEncontrado.setEdicao(livroCreateDTO.getEdicao());
        livroEncontrado.setAutor(livroCreateDTO.getAutor());
        livroEncontrado.setPreco(livroCreateDTO.getPreco());
        livroEncontrado.setQuantidade(livroCreateDTO.getQuantidade());
        return objectMapper.convertValue(livroEncontrado, LivroDTO.class);
    }

    public void excluirLivro(Integer idLivro) throws RegraDeNegocioException {
        LivroEntity livroEncontrado = buscarLivroPorId(idLivro);
        livroRepository.delete(livroEncontrado);
    }

    public List<LivroDTO> listarLivros() {
        return livroRepository
                .findAll()
                .stream()
                .map(livroEntity -> objectMapper.convertValue(livroEntity, LivroDTO.class))
                .collect(Collectors.toList());
    }

    public LivroEntity buscarLivroPorId(Integer idLivro) throws RegraDeNegocioException {
        return livroRepository
                .findById(idLivro)
                .orElseThrow(() -> new RegraDeNegocioException("Livro não encontrado"));
    }
}