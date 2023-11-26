package com.trabalho.wesley.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "aluno")
public class Aluno {
    @Id
    private Integer id;

    private String nome;
}
