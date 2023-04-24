package com.ada.testes.dto.out;

import com.ada.testes.dto.in.TransacaoCreateDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class TransacaoDTO extends TransacaoCreateDTO {

    @Schema(description = "ID da transação", example = "1")
    private Integer id_transacao;
}
