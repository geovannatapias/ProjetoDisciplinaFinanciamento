package util;
import modelo.Financiamento;

import java.util.Locale;
import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

    public double solicitarValorImovel() {
        double valor;
       do {
           System.out.print("Digite o valor do imóvel (R$): ");
           valor = scanner.nextDouble();
           if (valor <= 0) {
               System.out.println("Valor inválido. Digite outro valor.");
           }
       } while (valor <= 0);
            return valor;
        }
    public int solicitarPrazoFinanciamento() {
         int prazo;
        do {
            System.out.print("Digite o prazo do financiamento (em anos): ");
            prazo = scanner.nextInt();
            if (prazo < 1 || prazo > 40) {
                System.out.println("Prazo inválido. Digite novamente.");
            }
        } while (prazo < 1 || prazo > 40);
            return prazo;
        }
    public double solicitarTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros anual (%): ");
            taxa = scanner.nextDouble();
            if (taxa <= 1.0 || taxa > 100.00) {
                System.out.println("Taxa de Juros inválida. Digite novamente. ");
            }
        } while (taxa <= 1.0 || taxa > 100.00);
        return taxa;
    }
    public Financiamento obterDadosFinanciamento() {
        double valor = solicitarValorImovel();
        int prazo = solicitarPrazoFinanciamento();
        double taxa = solicitarTaxaJuros();
        return new Financiamento(valor, prazo, taxa);
    }
    public void fecharScanner() {
        scanner.close();
    }
}