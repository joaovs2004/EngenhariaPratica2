package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private LocalDateTime dataInicioConsulta;
    private int duracaoMinutos;

    private Paciente paciente;
    private Medico medico;

    private Atestado atestado; // 0..1
    private List<Prescricao> prescricoes = new ArrayList<>();

    public Consulta(LocalDateTime dataInicioConsulta, int duracaoMinutos, Paciente paciente, Medico medico) {
        this.dataInicioConsulta = dataInicioConsulta;
        this.duracaoMinutos = duracaoMinutos;
        this.paciente = paciente;
        this.medico = medico;
    }

    public void emitirAtestado(Atestado atestado) {
        this.atestado = atestado;
    }

    public void adicionarPrescricao(Prescricao prescricao) {
        prescricoes.add(prescricao);
    }

    public Paciente getPaciente() { return paciente; }
    public Medico getMedico() { return medico; }
    public LocalDateTime getDataInicioConsulta() { return dataInicioConsulta; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
}