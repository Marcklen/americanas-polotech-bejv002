package com.ada.testes.controller.doc;

import com.ada.testes.dto.in.TransacaoCreateDTO;
import com.ada.testes.dto.out.LivroDTO;
import com.ada.testes.dto.out.TransacaoDTO;
import com.ada.testes.exception.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Tag(name = "Endpoints de transacoes")
public interface TransacaoControllerDoc {

    @Operation(summary = "Adicionar transaco", description = "Adicionar uma transacao entre pessoa e livro no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Criado - Transacao adicionada com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @PostMapping
    ResponseEntity<TransacaoDTO> cadastrarTransacao(Integer idPessoa,
                                                    Set<LivroDTO> livros,
                                                    @RequestBody TransacaoCreateDTO transacaoCreateDTO) throws RegraDeNegocioException;


    @Operation(summary = "Listar trasacoes", description = "Listas de transacoes cadastradas no banco de dados")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Ok - Retorna uma lista de transacoes"),
                    @ApiResponse(responseCode = "400", description = "Requisição inválida"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
            }
    )
    @GetMapping
    ResponseEntity<List<TransacaoDTO>> listar();
}