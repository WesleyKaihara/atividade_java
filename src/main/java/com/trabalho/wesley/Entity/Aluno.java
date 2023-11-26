package com.trabalho.wesley.Entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "aluno")
    private Set<AlunoCurso> alunoCurso;
}
