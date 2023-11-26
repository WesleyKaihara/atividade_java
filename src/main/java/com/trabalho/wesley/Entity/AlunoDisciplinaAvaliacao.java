package com.trabalho.wesley.Entity;

import com.trabalho.wesley.Entity.Key.AlunoCursoKey;
import com.trabalho.wesley.Entity.Key.AlunoDisciplinaAvaliacaoKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AlunoDisciplinaAvaliacao {
    @EmbeddedId
    private AlunoDisciplinaAvaliacaoKey id;

    @ManyToOne
    @MapsId("alunoId")
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @MapsId("disciplinaAvaliacaoId")
    @JoinColumn(name = "disciplina_avaliacao_id")
    private DisciplinaAvaliacao disciplinaAvaliacao;

    private Float nota;
}
