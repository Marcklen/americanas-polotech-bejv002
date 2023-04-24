package com.ada.testes.dto.out;

import com.ada.testes.dto.in.PessoaCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PessoaDTO extends PessoaCreateDTO {
    @Schema(description = "ID referente a pessoa", example = "1")
    private Integer id_pessoa;
}