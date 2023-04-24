package com.ada.testes.controller;

import com.ada.testes.controller.doc.TransacaoControllerDoc;
import com.ada.testes.dto.in.TransacaoCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.dto.out.TransacaoDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/transacoes")
public class TransacaoController implements TransacaoControllerDoc {

    private final TransacaoService transacaoService;

    @Override
    public ResponseEntity<TransacaoDTO> cadastrarTransacao(Integer idPessoa, Set<LivroDTO> livros, TransacaoCreateDTO transacaoCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(transacaoService.cadastrarTransacao(idPessoa, livros, transacaoCreateDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TransacaoDTO>> listar() {
        return new ResponseEntity<>(transacaoService.listar(), HttpStatus.OK);
    }
}