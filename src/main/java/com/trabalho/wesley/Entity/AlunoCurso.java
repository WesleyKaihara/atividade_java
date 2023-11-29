package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.wesley.Entity.Key.AlunoCursoKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AlunoCurso {

    @EmbeddedId
    @JsonIgnore
    private AlunoCursoKey alunoCurso;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    @JsonIgnoreProperties({ "alunoCursos" })
    private Aluno aluno;

    @ManyToOne
    @MapsId("cursoId")
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
