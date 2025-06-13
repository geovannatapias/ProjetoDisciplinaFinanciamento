package modelo;

public class Terreno extends Financiamento {
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    @Override
    public double calcularPagamentoMensal() {
        double parcelaBruta = super.calcularPagamentoMensal();
        return parcelaBruta * 1.02;
    }
}
