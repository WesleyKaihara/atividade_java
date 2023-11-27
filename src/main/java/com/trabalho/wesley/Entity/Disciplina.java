package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "disciplina")
@Getter
@Setter
@NoArgsConstructor
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "listaDisciplinas", "hibernateLazyInitializer"})
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    @JsonIgnoreProperties({ "disciplina"})
    private List<DisciplinaAvaliacao> avaliacoes;

}
