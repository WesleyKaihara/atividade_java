package com.trabalho.wesley.Entity.Key;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class AlunoCursoKey implements Serializable {

    @Column(name = "aluno_id")
    private Integer alunoId;

    @Column(name = "curso_id")
    private Integer cursoId;
}
