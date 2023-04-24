package com.ada.testes.dto.out;

import com.ada.testes.dto.in.LivroCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class LivroDTO extends LivroCreateDTO {

    @Schema(description = "ID referente ao livro", example = "1")
    private Integer id_livro;
}