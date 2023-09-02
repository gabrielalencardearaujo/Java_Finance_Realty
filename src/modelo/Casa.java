package modelo;

import java.util.Scanner;

public class Casa extends Financiamento {
  Scanner input = new Scanner(System.in);
  private float desconto; 

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.descontoParcela();
  }

  public void descontoParcela() {
    String controlador;

    while (true) {

      System.out.print("\nDeseja aplicar algum desconto nas mensalidades do financiamento da casa? S/N");
      controlador = input.next();

      if (controlador.toUpperCase() == "S") {
        System.out.println("Quanto é o desconto: (ate 100 reais) ");
        desconto = input.nextFloat();
      }

      if (desconto < 100 && desconto > 0) {
        this.setPagamentoMensal(this.getPagamentoMensal() - desconto);
        break;
      } else {
        System.out.println("O desconto deve ser de ate 100 reais!");
        continue;
      }
    };

    System.out.println("Desconto de " + desconto + " foi aplicado com sucesso");
  }
}
