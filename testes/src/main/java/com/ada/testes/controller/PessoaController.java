package com.ada.testes.controller;

import com.ada.testes.controller.doc.PessoaControllerDoc;
import com.ada.testes.dto.in.PessoaCreateDTO;
import com.ada.testes.dto.out.PessoaDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/pessoas")
public class PessoaController implements PessoaControllerDoc {

    private final PessoaService pessoaService;

    @Override
    public ResponseEntity<PessoaDTO> cadastrar(PessoaCreateDTO pessoaCreateDTO) {
        return new ResponseEntity<>(pessoaService.cadastrarPessoa(pessoaCreateDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PessoaDTO> editar(Integer idPessoa, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(pessoaService.editarPessoa(idPessoa, pessoaCreateDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PessoaDTO>> listar() {
        return new ResponseEntity<>(pessoaService.listarPessoas(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<PessoaDTO>> buscaPorEMAIL(String email) {
        return new ResponseEntity<>(pessoaService.buscarPorEmail(email), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<PessoaDTO>> buscaPorCPF(String cpf) {
        return new ResponseEntity<>(pessoaService.buscarPorCPF(cpf), HttpStatus.OK);
    }
}
