package com.ada.testes.controller.doc;

import com.ada.testes.dto.in.PessoaCreateDTO;
import com.ada.testes.dto.out.PessoaDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Tag(name = "Endpoints de pessoas")
public interface PessoaControllerDoc {

    @Operation(summary = "Adicionar pessoa", description = "Adicionar uma pessoa ao banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criado - Pessoa adicionada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @PostMapping
    ResponseEntity<PessoaDTO> cadastrar(@Valid @RequestBody PessoaCreateDTO pessoaCreateDTO);

    @Operation(summary = "Editar pessoa", description = "Editar uma pessoa no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Editado - Pessoa editada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @PutMapping("/{idPessoa}")
    ResponseEntity<PessoaDTO> editar(@PathVariable Integer idPessoa,
                                     @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException;


    @Operation(summary = "Listar pessoas", description = "Listas pessoas cadastradas no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok - Retorna uma lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping
    ResponseEntity<List<PessoaDTO>> listar();

    @Operation(summary = "Buscar por email", description = "Buscar uma pessoa pelo email cadastrado no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok - Retorna uma lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping("/buscar-por-email/{email}")
    ResponseEntity<Optional<PessoaDTO>> buscaPorEMAIL(@Valid @PathVariable String email);

    @Operation(summary = "Buscar por cpf", description = "Buscar uma pessoa pelo cpf cadastrado no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok - Retorna uma lista de pessoas"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping("/buscar-por-cpf/{cpf}")
    ResponseEntity<Optional<PessoaDTO>> buscaPorCPF(@Valid @PathVariable String cpf);
}