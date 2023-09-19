package util;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Financiamento;
import java.text.DecimalFormat;
import modelo.*;

public class InterfaceUsuario implements InterUsuario {
    private Scanner inputUser = new Scanner(System.in);
    private DecimalFormat df = new DecimalFormat("#.##");

    public double inputValorImovel() {
        double valorImovel = 0;

        while (valorImovel <= 0) {
            System.out.print("Digite o valor do imovel: ");
            valorImovel = inputUser.nextDouble();

            if (valorImovel > 0)
                break;

            System.out.println("O valor deve ser maior que zero.\n");
        }
        ;

        return valorImovel;
    }

    public int inputPrazoFinanciamento() {
        int prazoFinanciamento;

        do {
            System.out.print("Digite o prazo de Financiamento em anos: ");
            prazoFinanciamento = inputUser.nextInt();

            if (prazoFinanciamento <= 0)
                System.out.println("O valor deve ser maior que zero.\n");

        } while (prazoFinanciamento <= 0);

        return prazoFinanciamento;
    }

    public double inputTaxaJuros() {
        double taxaJuros;
        do {
            System.out.print("Digite a taxa de juros anual: ");
            taxaJuros = inputUser.nextDouble();

            if (taxaJuros <= 0)
                System.out.println("A taxa de juros nao pode ser menor que zero.\n");

        } while (taxaJuros <= 0);
        return taxaJuros;
    }

    public double areaCasaConstruida() {
        System.out.println("Qual a area construida? ");
        double area = inputUser.nextDouble();
        return area;
    }

    public double areaCasaTerreno() {
        System.out.println("Qual a area do terreno? ");
        double area = inputUser.nextDouble();
        return area;
    }

    public float descontoCasa() {
        while (true) {
            try {
                System.out.print("\nDeseja aplicar algum desconto nas mensalidades do financiamento da casa? S/N  ");
                String controlador = inputUser.next().toUpperCase();

                if (controlador.equals("S")) {
                System.out.println("Quanto é o desconto: (ate 100 reais) ");
                return inputUser.nextFloat();
                } else return 0f;

            } catch(NullPointerException e){
                System.out.println(e.getMessage());
                continue;
            }catch(RuntimeException e) {
                System.out.println("Algo inesperado aconteceu aqui. Tente novamente.");
                continue;
            }
        }
    }

    public int vagasGaragemApartamento() {
        System.out.println("Quantas vagas na garagem? ");
        int vagas = inputUser.nextInt();

        return vagas;
    }

    public int andarApartamento() {
        System.out.println("Qual o andar do apartamento? ");
        int andar = inputUser.nextInt();

        return andar;
    }

    public String zonaTerreno() {
        System.out.println("Qual a zona do terreno? (Residencial ou Comercial) ");
        String zona = inputUser.next();
        return zona;
    }

    public String presentation() {
        while (true) {
            try {
                System.out.println("Que tipo de financiamento deseja realizar? Temos 3 tipos de financiamento: \n");
                System.out.println("CASA | APARTAMENTO | TERRENO");
                String escolhaFinanciamento = inputUser.next().toUpperCase();

                if (!escolhaFinanciamento.toUpperCase().equals("CASA") &&
                        !escolhaFinanciamento.toUpperCase().equals("APARTAMENTO") &&
                        !escolhaFinanciamento.toUpperCase().equals("TERRENO"))
                    throw new RuntimeException("\nDigite uma das opcoes abaixo. Exemplo: Casa");

                return escolhaFinanciamento;
            } catch (NullPointerException e) {
                System.out.println("Digite um valor valido.");
                continue;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }
    }

    public void mostrarFinanciamentos(ArrayList<Financiamento> financiamentos) {
        int cont = 1;
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for(Financiamento fin: financiamentos) {
            System.out.println("\n\nFinanciamento " + cont + ":" );

            if (fin.getClass().getSimpleName().equals("Casa")) 
                System.out.println("\nTipo do Financiamento: CASA");

            if(fin.getClass().getSimpleName().equals("Apartamento"))
                System.out.println("\nTipo do Financiamento: APARTAMENTO");
            
            if(fin.getClass().getSimpleName().equals("Apartamento"))
                System.out.println("\nTipo do Financiamento: Terreno");

            fin.mostrarFinanciamentos(cont);
            totalImoveis += fin.getValorImovel();
            totalFinanciamentos += fin.totalPagamento();
            cont++;
        }

        System.out.println("\nValor total dos imoveis: R$ " + this.df.format(totalImoveis));
        System.out.println("Valor total dos financiamentos: R$ " + this.df.format(totalFinanciamentos));
    }

    // public static void resultFinanciamento(double pagamentoMensal, double
    // pagamentoTotal){
    // System.out.println("\n O pagamento mensal do imovel: " + pagamentoMensal);
    // System.out.println("O pagamento total do imovel: " + pagamentoTotal);
    // System.out.println("");
    // }
}
