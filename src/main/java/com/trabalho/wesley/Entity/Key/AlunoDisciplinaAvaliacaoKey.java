package com.trabalho.wesley.Entity.Key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class AlunoDisciplinaAvaliacaoKey implements Serializable {
    @Column(name = "aluno_id")
    private Integer alunoId;

    @Column(name = "disciplina_avaliacao_id")
    private Integer disciplinaAvaliacaoId;

}
