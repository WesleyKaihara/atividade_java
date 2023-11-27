package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DisciplinaAvaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Float valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "avaliacoes", "hibernateLazyInitializer" })
    private Disciplina disciplina;
}
