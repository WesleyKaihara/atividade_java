package com.trabalho.wesley.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AlunoDisciplinaAvaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
