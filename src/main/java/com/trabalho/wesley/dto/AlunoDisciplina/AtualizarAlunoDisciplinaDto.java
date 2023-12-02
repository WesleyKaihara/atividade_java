package com.trabalho.wesley.dto.AlunoDisciplina;

import lombok.Getter;

@Getter
public class AtualizarAlunoDisciplinaDto {
    private Integer alunoId;
    private Integer discplinaId;
    private Float provas;
    private Float trabalhos;
    private Float recuperacao;
}
