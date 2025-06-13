package modelo;

public class Apartamento extends Financiamento {
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int totalMeses = prazoFinanciamento * 12;

        double fator = Math.pow(1 + taxaMensal, totalMeses);

        // Fórmula PRICE:
        double parcela = valorImovel * taxaMensal * fator / (fator - 1);
        return parcela;
    }
}



