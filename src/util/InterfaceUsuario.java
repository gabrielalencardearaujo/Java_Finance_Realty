package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner inputUser = new Scanner(System.in);

    public double inputValorImovel(){
        double valorImovel;

        while(true){
            System.out.print("Digite o valor do imovel: ");
            valorImovel = inputUser.nextDouble();
            
            if(valorImovel <= 0) {
                System.out.println("Valor do imovel nao pode ser menor ou igual a zero.\n");
                continue;
            } 

            return valorImovel;
        }
    }

    public int inputPrazoFinanciamento(){
        int prazoFinanciamento;

        while(true) {
            System.out.print("Digite o prazo de Financiamento em anos: ");
            prazoFinanciamento =  inputUser.nextInt();

            if(prazoFinanciamento < 0) {
                System.out.println("O prazo nao deve ser menor ou igual a zero.\n");
                continue;
            } 

            return prazoFinanciamento;
        } 
    }

    public double inputTaxaJuros(){
        double taxaJuros;

        System.out.print("Digite a taxa de juros anual: ");
        taxaJuros = inputUser.nextDouble();
        
        if(taxaJuros < 0) {
            System.out.println("A taxa de juros nao pode ser menor que zero.\n");
            this.inputTaxaJuros();
        } 

        return taxaJuros;
        
    }

    public static void resultFinanciamento(double pagamentoMensal, double pagamentoTotal){
        System.out.println("O pagamento anual do imovel: " + pagamentoMensal);
        System.out.println("O pagamento total do imovel: " + pagamentoTotal);
    }
}
