package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "aluno")
@Getter
@Setter
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({ "aluno", "id" })
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<AlunoCurso> alunoCursos;

    @OneToMany(mappedBy = "alunoDisciplina.aluno")
    private List<AlunoDisciplina> alunoDisciplinas;
}
