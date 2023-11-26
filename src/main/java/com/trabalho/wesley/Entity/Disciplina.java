package com.trabalho.wesley.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private List<DisciplinaAvaliacao> avaliacoes;

}
