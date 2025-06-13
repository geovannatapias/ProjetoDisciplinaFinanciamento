package main;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        List<Financiamento> financiamentos = new ArrayList<>();
        financiamentos.add(new Casa(200000, 20, 4.5)); //2x de cada 1x terreno subclasse no array list
        financiamentos.add(new Casa(300000, 25, 6.0));//sumario do array list e soma loop
        financiamentos.add(new Apartamento(150000, 15, 5.0));
        financiamentos.add(new Apartamento(500000, 30, 7.5));
        financiamentos.add(new Terreno(350000, 28, 6.5));

        System.out.println("Digite os dados do novo financiamento: ");
        Financiamento novoFinanciamento = interfaceUsuario.obterDadosFinanciamento();
        financiamentos.add(novoFinanciamento);

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        System.out.println("DETALHAMENTO DOS CONTRATOS DE FINANCIAMENTO"); //alterar

        int contador = 1;
        for (Financiamento f : financiamentos) {
            System.out.println("\nFinanciamento " + contador++);
            f.exibirDadosFinanciamento();

            totalValorImoveis += f.getValorImovel();
            totalValorFinanciamentos += f.calcularPagamentoTotal();
        }

        System.out.println("\nBALANÇO FINAL DO INVESTIMENTO");
        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);


        interfaceUsuario.fecharScanner();
    }
}





