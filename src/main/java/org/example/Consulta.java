package org.example;

import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime dataInicioConsulta;
    private Double duracaoMinutos;
    private Paciente paciente;
    static Double antecedenciaCancelamentoMinutos;

    public Consulta(LocalDateTime dataInicioConsulta, Double duracaoMinutos, Paciente paciente) {
        this.dataInicioConsulta = dataInicioConsulta;
        this.duracaoMinutos = duracaoMinutos;
        this.paciente = paciente;
    }

    public LocalDateTime getDataInicioConsulta() {
        return dataInicioConsulta;
    }

    public void setDataInicioConsulta(LocalDateTime dataInicioConsulta) {
        this.dataInicioConsulta = dataInicioConsulta;
    }

    public Double getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Double duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public static Double getAntecedenciaCancelamentoMinutos() {
        return antecedenciaCancelamentoMinutos;
    }

    public static void setAntecedenciaCancelamentoMinutos(Double antecedenciaCancelamentoMinutos) {
        Consulta.antecedenciaCancelamentoMinutos = antecedenciaCancelamentoMinutos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
