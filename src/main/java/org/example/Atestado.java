package org.example;

import java.time.LocalDate;

public class Atestado {
    private LocalDate dataInicio;
    private int duracaoDias;

    public Atestado(LocalDate dataInicio, int duracaoDias) {
        this.dataInicio = dataInicio;
        this.duracaoDias = duracaoDias;
    }
}