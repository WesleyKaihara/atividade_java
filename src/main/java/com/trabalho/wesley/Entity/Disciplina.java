package com.trabalho.wesley.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "disciplina")
    private List<DisciplinaAvaliacao> avaliacoes;

}
