package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "curso")
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Integer duracao;

    @OneToMany(mappedBy = "curso")
    @JsonIgnore
    private Set<AlunoCurso> alunoCurso;

    @OneToMany(mappedBy = "curso")
    @JsonIgnoreProperties({ "curso" })
    private List<Disciplina> listaDisciplinas;
}

