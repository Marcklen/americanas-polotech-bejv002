package com.ada.testes.dto.in;

import com.ada.testes.dto.out.LivroDTO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Set;

@Data
public class TransacaoCreateDTO {

    private Integer id_pessoa;
    @Qualifier("id_livro")
    private Set<LivroDTO> id_livro;
}
