package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescricao {
    private LocalDate data;
    private List<PrescricaoMedicamento> medicamentos = new ArrayList<>();

    public Prescricao(LocalDate data) {
        this.data = data;
    }

    public void adicionarMedicamento(Medicamento m, int quantidade) {
        medicamentos.add(new PrescricaoMedicamento(m, quantidade));
    }

    public List<PrescricaoMedicamento> getMedicamentos() {
        return medicamentos;
    }
}