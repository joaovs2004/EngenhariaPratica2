package org.example;

public class PrescricaoMedicamento {
    private Medicamento medicamento;
    private int quantidade;

    public PrescricaoMedicamento(Medicamento medicamento, int quantidade) {
        this.medicamento = medicamento;
        this.quantidade = quantidade;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
}