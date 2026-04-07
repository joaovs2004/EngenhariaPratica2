package org.example;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    static void main() {
        ArrayList<Consulta> consultas = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        IO.println("==========");
        IO.println("1 - Criar Paciente");
        IO.println("2 - Listar Paciente");
        IO.println("3 - Agendar Consulta");
        IO.println("4 - Listar Consulta");
        IO.println("4 - Cancelar Consulta");
        IO.println("5 - Sair");

        IO.println("==========");

        String opcaoEscolhida = IO.readln();

        while (opcaoEscolhida != "5") {
            switch (opcaoEscolhida) {
                case "1":
                    Paciente novoPaciente = Main.criarPaciente();
                    pacientes.add(novoPaciente);
                    break;
                case "2":
                    Main.listarPacientes(pacientes);
                    break;
                case "3":
                    Consulta novaConsulta = Main.criarConsulta(pacientes);
                    consultas.add(novaConsulta);
                    break;
                case "4":
                    Main.listarConsultas(consultas);
                    break;
                case "5":
                    break;
            }
        }


    }

    static Paciente criarPaciente() {
        IO.println("Digite o nome do paciente: ");
        String nome = IO.readln();

        IO.println("Digite a idade do paciente: ");
        String idade = IO.readln();

        IO.println("Digite o cpf do paciente: ");
        String cpf = IO.readln();

        Paciente paciente = new Paciente(nome, Integer.parseInt(idade), cpf);

        return paciente;
    }

    static void listarPacientes(ArrayList<Paciente> listaPacientes) {
        for (Paciente paciente : listaPacientes) {
            IO.println("Nome do paciente " + paciente.getNome() + " Idade do paciente: " + paciente.getIdade());
        }
    }

    static Consulta criarConsulta(ArrayList<Paciente> listaPacientes) {
        IO.println("Digite o cpf do cliente que vai ser consultado: ");
        String cpf = IO.readln();

        IO.println("Digite a data da consulta. Formato (yyyy-MM-dd HH:mm)");

        String data = IO.readln();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dataConsulta = LocalDateTime.parse(data, formatter);

        IO.println("Digite a duração em minutos da consulta");
        String duracao = IO.readln();

        Optional<Paciente> paciente = listaPacientes.stream().filter(p -> p.getCpf() == cpf).findFirst();

        Consulta novaConsulta = new Consulta(dataConsulta, Double.parseDouble(duracao), paciente.get());

        return novaConsulta;
    }

    static void listarConsultas(ArrayList<Consulta> consultas) {
        for (Consulta consulta : consultas) {
            IO.println("Consulta " + consulta.getDataInicioConsulta() + " Duração" + consulta.getDuracaoMinutos() + " Paciente" + consulta.getPaciente().getNome());
        }
    }
}
