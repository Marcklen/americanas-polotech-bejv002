package com.ada.testes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_TRANSACAO") // tabela que vai armazenar a transacao de pessoa_x_livro
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TRANSACAO")
    @SequenceGenerator(name = "SEQ_TRANSACAO", sequenceName = "SEQ_TRANSACAO", allocationSize = 1)
    @Column(name = "ID_TRANSACAO")
    private Integer id_transacao;

    // RELACIONAMENTO COM PESSOA
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
    @JsonIgnore
    private PessoaEntity pessoa;

    // RELACIONAMENTO COM LIVRO
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TB_TRANSACAO_LIVRO",
            joinColumns = @JoinColumn(name = "id_transacao"),
            inverseJoinColumns = @JoinColumn(name = "id_livro"))
    @JsonIgnore
    @Qualifier("id_livro")
    private Set<LivroEntity> livros;

}