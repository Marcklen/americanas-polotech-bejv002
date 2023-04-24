package com.ada.testes.service;

import com.ada.testes.dto.in.TransacaoCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.dto.out.TransacaoDTO;
import com.ada.testes.entity.LivroEntity;
import com.ada.testes.entity.PessoaEntity;
import com.ada.testes.entity.TransacaoEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.TransacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final PessoaService pessoaService;
    private final LivroService livroService;
    private final ObjectMapper objectMapper;

    // cadastrar transacao
    @Transactional
    public TransacaoDTO cadastrarTransacao(Integer idPessoa, Set<LivroDTO> livroDTOS, TransacaoCreateDTO transacaoCreateDTO) throws RegraDeNegocioException {
        // verificar se a pessoa existe
        PessoaEntity pessoaEntity = pessoaService.buscarPessoaPorId(idPessoa);
        // verificar se o livro existe numa lista
        Set<LivroEntity> livroEntities = livroDTOS
                .stream()
                .map(livroDTO -> {
                    try {
                        return livroService.buscarLivroPorId(livroDTO.getId_livro());
                    } catch (RegraDeNegocioException e) {
                        log.info("Livro não encontrado" + e.getMessage());
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toSet());
        // verificar se o livro tem quantidade
        if (livroEntities.stream().anyMatch(livroEntity -> livroEntity.getQuantidade() == 0)) {
            throw new RegraDeNegocioException("Livro indisponível");
        }
        // verificar se a pessoa ja possui o livro
        if (livroEntities.stream().anyMatch(
                livroEntity -> pessoaEntity.getTransacao().contains(livroEntity))) {
            throw new RegraDeNegocioException("Livro já adquirido");
        }
        // verificar se a pessoa tem saldo
        if (pessoaEntity.getSaldo().doubleValue() < livroDTOS.stream().mapToDouble(LivroDTO::getPreco).sum()) {
            throw new RegraDeNegocioException("Saldo insuficiente");
        } else if (pessoaEntity.getSaldo() > 0 && livroDTOS.stream().mapToDouble(LivroDTO::getPreco).sum() > 0) {
            pessoaEntity.setSaldo(pessoaEntity.getSaldo() - livroDTOS.stream().mapToDouble(LivroDTO::getPreco).count());
            livroEntities.forEach(livroEntity ->
                    livroEntity.setQuantidade(livroEntity.getQuantidade() - 1));
        }

        TransacaoEntity transacaoEntity = objectMapper.convertValue(transacaoCreateDTO, TransacaoEntity.class);
        TransacaoDTO transacaoDTO = objectMapper.convertValue(transacaoEntity, TransacaoDTO.class);
        transacaoDTO.setId_pessoa(idPessoa);
        transacaoDTO.setId_livro(livroDTOS);
        transacaoEntity.setPessoa(pessoaEntity);
        transacaoEntity.setLivros(livroEntities);
        transacaoEntity = transacaoRepository.save(transacaoEntity);
        transacaoDTO = objectMapper.convertValue(transacaoEntity, TransacaoDTO.class);
        return transacaoDTO;
    }

    // listar transacoes
    public List<TransacaoDTO> listar() {
        return transacaoRepository
                .findAll()
                .stream()
                .map(transacaoEntity -> objectMapper.convertValue(transacaoEntity, TransacaoDTO.class))
                .collect(Collectors.toList());
    }

}