package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.wesley.Entity.Key.AlunoDisciplinaKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class AlunoDisciplina implements Serializable {
    @EmbeddedId
    private AlunoDisciplinaKey alunoDisciplina;

    @Max(70)
    @Min(0)
    private Float provas;

    @Max(30)
    @Min(0)
    private Float trabalhos;

    @Max(100)
    @Min(0)
    private Float recuperacao;
}
