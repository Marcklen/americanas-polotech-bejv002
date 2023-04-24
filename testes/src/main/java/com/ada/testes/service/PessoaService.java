package com.ada.testes.service;

import com.ada.testes.dto.in.PessoaCreateDTO;
import com.ada.testes.dto.out.PessoaDTO;
import com.ada.testes.entity.PessoaEntity;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO cadastrarPessoa(PessoaCreateDTO pessoaCreateDTO) { // throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        pessoaEntity = pessoaRepository.save(pessoaEntity);
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public PessoaDTO editarPessoa(Integer idPessoa, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException { // throws RegraDeNegocioException {
        PessoaEntity pessoaEncontrada = buscarPessoaPorId(idPessoa);
        // só é permitido alterar o nome, email e telefone
        pessoaEncontrada.setNome(pessoaCreateDTO.getNome());
        pessoaEncontrada.setEmail(pessoaCreateDTO.getEmail());
        pessoaEncontrada.setTelefone(pessoaCreateDTO.getTelefone());
        pessoaEncontrada = pessoaRepository.save(pessoaEncontrada);
        return objectMapper.convertValue(pessoaEncontrada, PessoaDTO.class);
    }

    public List<PessoaDTO> listarPessoas() {
        return pessoaRepository
                .findAll()
                .stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<PessoaDTO> buscarPorCPF(String cpf) { // throws RegraDeNegocioException {
        return pessoaRepository
                .findByCpf(cpf)
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class));
    }

    public Optional<PessoaDTO> buscarPorEmail(String email) { // throws RegraDeNegocioException {
        return pessoaRepository
                .findByEmail(email)
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class));
    }

    public PessoaEntity buscarPessoaPorId(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository
                .findById(idPessoa)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }
}