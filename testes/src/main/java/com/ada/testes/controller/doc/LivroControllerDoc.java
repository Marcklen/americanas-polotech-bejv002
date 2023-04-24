package com.ada.testes.controller.doc;

import com.ada.testes.dto.in.LivroCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Endpoints de livros")
public interface LivroControllerDoc {

    @Operation(summary = "Adicionar livro", description = "Adicionar um livro ao banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criado - Livro adicionado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @PostMapping
    ResponseEntity<LivroDTO> cadastrar(@Valid @RequestBody LivroCreateDTO livroCreateDTO);

    @Operation(summary = "Editar livro", description = "Edita um livro do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editado - Livro editado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @PutMapping("/{idLivro}")
    ResponseEntity<LivroDTO> editar(@PathVariable Integer idLivro, @Valid @RequestBody LivroCreateDTO livroCreateDTO) throws RegraDeNegocioException;

    @Operation(summary = "Listar livros", description = "Lista de livros cadastrados no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listado - Lista de livros cadastrados"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping
    ResponseEntity<List<LivroDTO>> listar();

    @Operation(summary = "Deletar livro", description = "Deleta um livro do banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204", description = "Deletado - Livro deletado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @DeleteMapping("/{idLivro}")
    ResponseEntity<Void> deletar(@PathVariable Integer idLivro) throws RegraDeNegocioException;

}