package com.trabalho.wesley.enums;

public enum Modalidade {
    PRESENCIAL(1),
    A_DISTANCIA(2),
    SEMIPRESENCIAL(3);

    public final Integer id;

    private Modalidade(Integer id) {
        this.id = id;
    }
}
