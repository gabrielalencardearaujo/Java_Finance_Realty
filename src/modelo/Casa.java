package modelo;

import java.util.Scanner;

public class Casa extends Financiamento {
  Scanner input = new Scanner(System.in);
  private double desconto, areaConstruida, areaTerreno; 

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setAreaTerreno(areaTerreno);
    this.setAreaConstruida(areaConstruida);
    this.desconto = 0;

    this.descontoParcela();
  }

  public void descontoParcela() {
    String controlador;

    while (true) {

      System.out.print("\nDeseja aplicar algum desconto nas mensalidades do financiamento da casa? S/N  ");
      controlador = input.next().toUpperCase();

      if (controlador.equals("S")) {
        System.out.println("Quanto é o desconto: (ate 100 reais) ");
        this.desconto = input.nextFloat();
      } else return;
      

      if (this.desconto < 100 && this.desconto > 0) {
        this.setPagamentoMensal(this.getPagamentoMensal() - this.desconto);
        break;
      } else {
        System.out.println("O desconto deve ser de ate 100 reais!");
        continue;
      }
    };

    System.out.println("Desconto de " + desconto + " reais foi aplicado com sucesso.");
  }

  public double getAreaTerreno(){
    return this.areaTerreno;
  }

   public void setAreaTerreno(double areaTerreno){
    this.areaTerreno = areaTerreno;
  }

    public double getAreaConstruida(){
    return this.areaConstruida;
  }

   public void setAreaConstruida(double areaConstruida){
    this.areaConstruida = areaConstruida;
  }
}
