package com.trabalho.wesley.Entity.Key;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.wesley.Entity.Aluno;
import com.trabalho.wesley.Entity.Curso;
import com.trabalho.wesley.Entity.Disciplina;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class AlunoDisciplinaKey implements Serializable {

    @ManyToOne
    @JsonIgnoreProperties({ "alunoDisciplinas", "alunoCursos" })
    private Aluno aluno;

    @ManyToOne
    @JsonIgnoreProperties({ "curso" })
    private Disciplina disciplina;

    @ManyToOne
    @JsonIgnoreProperties({ "listaDisciplinas" })
    private Curso curso;
}
