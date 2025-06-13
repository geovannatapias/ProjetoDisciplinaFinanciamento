package modelo;

public class Financiamento {
    protected double valorImovel;
    protected int prazoFinanciamento; //anos;
    protected double taxaJurosAnual;

    public Financiamento (double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
       return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    //Metodo calcular pagamento mensal
    public double calcularPagamentoMensal() {
        int totalMeses = prazoFinanciamento * 12;
        return (valorImovel / totalMeses) * (1 + (taxaJurosAnual / 12 / 100));
    }

    //Metodo calcular pagamento total
    public double calcularPagamentoTotal() {

        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public void exibirDadosFinanciamento() {
        System.out.println("Dados do Financiamento: ");
        System.out.printf("Valor do Imóvel: R$ %.2f%n", valorImovel);
        System.out.printf("Prazo: %d anos (%d meses)%n", prazoFinanciamento, prazoFinanciamento * 12);
        System.out.printf("Taxa de Juros Anual: %.2f%%%n", taxaJurosAnual);
        System.out.printf("Pagamento Mensal Estimado: R$ %.2f%n", calcularPagamentoMensal());
        System.out.printf("Total Pago ao Final do Financiamento: R$ %.2f%n", calcularPagamentoTotal());
    }
}

