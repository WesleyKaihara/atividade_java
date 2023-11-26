package com.trabalho.wesley.Entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "aluno")
    private Set<AlunoCurso> alunoCurso;
}
