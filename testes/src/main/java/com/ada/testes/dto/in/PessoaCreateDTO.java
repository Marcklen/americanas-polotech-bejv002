package com.ada.testes.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotNull
    @NotEmpty
    @Schema(description = "Nome da pessoa", example = "João da Silva", required = true)
    private String nome; // permitido alteração

    @Schema(description = "Data de nascimento da pessoa", example = "2000-01-01", required = true)
    private LocalDate data_nascimento;

    @NotNull
    @NotEmpty
    @Schema(description = "CPF da pessoa", example = "123.456.789-00", required = true)
    private String cpf;

    @NotNull
    @NotEmpty
    @Schema(description = "Email da pessoa", example = "fulaninho@gmail.com", required = true)
    private String email; // permitido alteração

    @NotNull
    @NotEmpty
    @Schema(description = "Telefone da pessoa", example = "(85)988781234", required = true)
    private String telefone; // permitido alteração

    @Min(value = 0 , message = "O saldo deve ser maior ou igual a zero")
    @Schema(description = "Saldo da pessoa", example = "1000.00", required = true)
    private Double saldo;
}