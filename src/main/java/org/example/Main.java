package org.example;

import org.example.Medicamento;
import org.example.Paciente;
import org.example.Prescricao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n=== SISTEMA CLÍNICA ===");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Cadastrar médico");
            System.out.println("3 - Agendar consulta");
            System.out.println("4 - Emitir atestado");
            System.out.println("5 - Adicionar prescrição");
            System.out.println("6 - Listar consultas");
            System.out.println("0 - Sair");

            opcao = Integer.parseInt(IO.readln());

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = IO.readln();

                    System.out.print("CPF: ");
                    String cpf = IO.readln();

                    System.out.print("Ano nascimento: ");
                    int ano = Integer.parseInt(IO.readln());
                    System.out.print("Mês: ");
                    int mes = Integer.parseInt(IO.readln());
                    System.out.print("Dia: ");
                    int dia = Integer.parseInt(IO.readln());

                    pacientes.add(new Paciente(nome, cpf, LocalDate.of(ano, mes, dia)));
                    System.out.println("Paciente cadastrado!");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeMed = IO.readln();

                    System.out.print("CPF: ");
                    String cpfMed = IO.readln();

                    System.out.print("CRM: ");
                    String crm = IO.readln();

                    System.out.print("Especialidade: ");
                    String esp = IO.readln();

                    System.out.print("Ano nascimento: ");
                    int a = Integer.parseInt(IO.readln());
                    System.out.print("Mês: ");
                    int m = Integer.parseInt(IO.readln());
                    System.out.print("Dia: ");
                    int d = Integer.parseInt(IO.readln());

                    medicos.add(new Medico(nomeMed, cpfMed, LocalDate.of(a, m, d), crm, esp));
                    System.out.println("Médico cadastrado!");
                    break;

                case 3:
                    if (pacientes.isEmpty() || medicos.isEmpty()) {
                        System.out.println("Cadastre paciente e médico primeiro!");
                        break;
                    }

                    System.out.println("Escolha paciente:");
                    for (int i = 0; i < pacientes.size(); i++) {
                        System.out.println(i + " - " + pacientes.get(i).getNome());
                    }
                    int idxPac = Integer.parseInt(IO.readln());

                    System.out.println("Escolha médico:");
                    for (int i = 0; i < medicos.size(); i++) {
                        System.out.println(i + " - " + medicos.get(i).getNome());
                    }
                    int idxMed = Integer.parseInt(IO.readln());

                    System.out.print("Ano: ");
                    int anoC = Integer.parseInt(IO.readln());
                    System.out.print("Mês: ");
                    int mesC = Integer.parseInt(IO.readln());
                    System.out.print("Dia: ");
                    int diaC = Integer.parseInt(IO.readln());
                    System.out.print("Hora: ");
                    int hora = Integer.parseInt(IO.readln());
                    System.out.print("Minuto: ");
                    int minuto = Integer.parseInt(IO.readln());

                    System.out.print("Duração (min): ");
                    int duracao = Integer.parseInt(IO.readln());

                    LocalDateTime dataConsulta = LocalDateTime.of(anoC, mesC, diaC, hora, minuto);

                    Consulta consulta = new Consulta(
                            dataConsulta,
                            duracao,
                            pacientes.get(idxPac),
                            medicos.get(idxMed)
                    );

                    consultas.add(consulta);
                    System.out.println("Consulta agendada!");
                    break;

                case 4:
                    if (consultas.isEmpty()) {
                        System.out.println("Nenhuma consulta!");
                        break;
                    }

                    System.out.println("Escolha consulta:");
                    for (int i = 0; i < consultas.size(); i++) {
                        System.out.println(i + " - " +
                                consultas.get(i).getPaciente().getNome() +
                                " com " +
                                consultas.get(i).getMedico().getNome());
                    }

                    int idxConsAt = Integer.parseInt(IO.readln());

                    System.out.print("Dias de afastamento: ");
                    int dias = Integer.parseInt(IO.readln());

                    Atestado at = new Atestado(LocalDate.now(), dias);
                    consultas.get(idxConsAt).emitirAtestado(at);

                    System.out.println("Atestado emitido!");
                    break;

                case 5:
                    if (consultas.isEmpty()) {
                        System.out.println("Nenhuma consulta!");
                        break;
                    }

                    System.out.println("Escolha consulta:");
                    for (int i = 0; i < consultas.size(); i++) {
                        System.out.println(i + " - " +
                                consultas.get(i).getPaciente().getNome());
                    }

                    int idxConsPr = Integer.parseInt(IO.readln());

                    Prescricao p = new Prescricao(LocalDate.now());

                    String continuar;
                    do {
                        System.out.print("Nome medicamento: ");
                        String nomeMedicam = IO.readln();

                        System.out.print("Quantidade: ");
                        int qtd = Integer.parseInt(IO.readln());

                        Medicamento med = new Medicamento(nomeMedicam);
                        p.adicionarMedicamento(med, qtd);

                        System.out.print("Adicionar outro? (s/n): ");
                        continuar = IO.readln();

                    } while (continuar.equalsIgnoreCase("s"));

                    consultas.get(idxConsPr).adicionarPrescricao(p);

                    System.out.println("Prescrição adicionada!");
                    break;

                case 6:
                    for (Consulta c : consultas) {
                        System.out.println("\nPaciente: " + c.getPaciente().getNome());
                        System.out.println("Médico: " + c.getMedico().getNome());
                        System.out.println("Data: " + c.getDataInicioConsulta());
                        System.out.println("Duração: " + c.getDuracaoMinutos());
                    }
                    break;
            }

        } while (opcao != 0);
    }
}

