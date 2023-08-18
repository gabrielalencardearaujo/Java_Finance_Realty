package pacote2;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner inputUser = new Scanner(System.in);

    public double inputValorImovel(){
        System.out.print("Digite o valor do imovel: ");
        return inputUser.nextDouble();
    }

    public int inputPrazoFinanciamento(){
        System.out.print("Digite o prazo de Financiamento em anos: ");
        return inputUser.nextInt();
    }

    public double inputTaxaJuros(){
        System.out.print("Digite a taxa de juros anual: ");
        return inputUser.nextDouble();
    }

    public static void resultFinanciamento(double pagamentoMensal, double pagamentoTotal){
        System.out.println("O pagamento mensal do imovel: " + pagamentoMensal);
        System.out.println("O pagamento total do imovel: " + pagamentoTotal);
    }
}
