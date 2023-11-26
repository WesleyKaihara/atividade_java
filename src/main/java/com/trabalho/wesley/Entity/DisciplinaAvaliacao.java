package com.trabalho.wesley.Entity;

import jakarta.persistence.*;

@Entity
public class DisciplinaAvaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Float valor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Disciplina disciplina;
}
