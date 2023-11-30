package com.trabalho.wesley.dto.Boletim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trabalho.wesley.Entity.AlunoDisciplina;
import com.trabalho.wesley.Entity.Curso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoletimAlunoCursoDisciplina {

    @JsonIgnoreProperties({ "duracao" })
    private Curso curso;
    private AlunoDisciplina alunoDisciplina;
    private String status;
}
