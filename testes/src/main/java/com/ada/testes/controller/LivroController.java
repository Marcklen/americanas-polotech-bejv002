package com.ada.testes.controller;

import com.ada.testes.controller.doc.LivroControllerDoc;
import com.ada.testes.dto.in.LivroCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import com.ada.testes.service.LivroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/livros")
public class LivroController implements LivroControllerDoc {

    private final LivroService livroService;

    @Override
    public ResponseEntity<LivroDTO> cadastrar(LivroCreateDTO livroCreateDTO) {
        log.info("Cadastrando livro: {}", livroCreateDTO);
        return new ResponseEntity<>(livroService.cadastrarLivro(livroCreateDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LivroDTO> editar(Integer idLivro, LivroCreateDTO livroCreateDTO) throws RegraDeNegocioException {
        log.info("Editando livro: {}", livroCreateDTO);
        return new ResponseEntity<>(livroService.editarLivro(idLivro, livroCreateDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LivroDTO>> listar() {
        log.info("Listando livros");
        return new ResponseEntity<>(livroService.listarLivros(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletar(Integer idLivro) throws RegraDeNegocioException {
        log.info("Deletando livro: {}", idLivro);
        livroService.excluirLivro(idLivro);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}