package com.ada.testes.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_LIVRO")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIVRO")
    @SequenceGenerator(name = "SEQ_LIVRO", sequenceName = "SEQ_LIVRO", allocationSize = 1)
    private Integer id_livro;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "EDICAO")
    private String edicao;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "PRECO", precision = 10, scale = 2)
    private Double preco;
    @Column(name = "QUANTIDADE")
    private Integer quantidade;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "livros")
    @JsonIgnore
    private Set<TransacaoEntity> transacao;
}