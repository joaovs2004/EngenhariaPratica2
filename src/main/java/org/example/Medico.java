package org.example;

import java.time.LocalDate;

public class Medico {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String crm;
    private String especialidade;

    public Medico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    public String getNome() { return nome; }
    public String getCrm() { return crm; }
}