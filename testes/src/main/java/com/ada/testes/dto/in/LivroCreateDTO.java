package com.ada.testes.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;

@Data
public class LivroCreateDTO {

    @NotNull
    @NotEmpty
    @Schema(description = "Nome do livro", example = "A guerra dos tronos")
    private String nome;

    @NotNull
    @NotEmpty
    @Schema(description = "Edição do livro", example = "Suma - 1ª edição - 2019")
    private String edicao;

    @NotNull
    @NotEmpty
    @Schema(description = "Autor do livro", example = "George R. R. Martin")
    private String autor;

    @DecimalMin(value = "9.99", inclusive = false)
    @DecimalMax(value = "999.99", inclusive = false)
    @Schema(description = "Preço sugerido do Livro", example = "99.00")
    private Double preco;

    @Min(value = 1, message = "A quantidade deve ser maior ou igual a 1")
    @Schema(description = "Quantidade sugerida para estoque", example = "10")
    private Integer quantidade;
}
