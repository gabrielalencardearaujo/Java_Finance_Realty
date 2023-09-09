package util;

import java.util.Scanner;

public class InterfaceUsuario implements InterUsuario {
    private Scanner inputUser = new Scanner(System.in);

    public double inputValorImovel(){
        double valorImovel = 0;

        while (valorImovel <= 0) {
            System.out.print("Digite o valor do imovel: ");
            valorImovel = inputUser.nextDouble();
            
            if (valorImovel > 0) break;

            System.out.println("O valor deve ser maior que zero.\n");
        } ;
        
        return valorImovel;
    }

    public int inputPrazoFinanciamento(){
        int prazoFinanciamento;
        
        do {
            System.out.print("Digite o prazo de Financiamento em anos: ");
            prazoFinanciamento =  inputUser.nextInt();
    
            if(prazoFinanciamento <= 0) System.out.println("O valor deve ser maior que zero.\n");
               
        } while(prazoFinanciamento <= 0);

        return prazoFinanciamento;
    }

    public double inputTaxaJuros(){
        double taxaJuros;
        do {
            System.out.print("Digite a taxa de juros anual: ");
            taxaJuros = inputUser.nextDouble();
            
            if(taxaJuros <= 0) System.out.println("A taxa de juros nao pode ser menor que zero.\n");
            
        } while (taxaJuros <= 0);
        return taxaJuros;
    }

    public double areaCasaConstruida(){
        System.out.println("Qual a area construida? ");
        double area = inputUser.nextDouble();
        return area;
    }

    public double areaCasaTerreno(){
        System.out.println("Qual a area do terreno? ");
        double area = inputUser.nextDouble();
        return area;
    }


    public int vagasGaragemApartamento(){
        System.out.println("Quantas vagas na garagem? ");
        int vagas = inputUser.nextInt();

        return vagas;
    }

    public int andarApartamento(){
        System.out.println("Qual o andar do apartamento? ");
        int andar = inputUser.nextInt();

        return andar;
    }

    public String zonaTerreno(){
        System.out.println("Qual a zona do terreno? (Residencial ou Comercial) ");
        String zona = inputUser.next();
        return zona;
    }

    // public static void resultFinanciamento(double pagamentoMensal, double pagamentoTotal){
    //     System.out.println("\n O pagamento mensal do imovel: " + pagamentoMensal);
    //     System.out.println("O pagamento total do imovel: " + pagamentoTotal);
    //     System.out.println("");
    // }
}
