package app.modelo;

import java.util.Scanner;

public class Casa extends Financiamento {
  Scanner input = new Scanner(System.in);
  private double desconto, areaConstruida, areaTerreno; 

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setAreaTerreno(areaTerreno);
    this.setAreaConstruida(areaConstruida);
    this.desconto = 0;

    // this.descontoParcela();
  }

  public boolean verificaDesconto(float desconto) {
    if(desconto > 100 || desconto < 0) {
      System.out.println("Desconto deve estar entre 0 e 100 reais.");
      return false;
    }
    
    if(desconto > super.pagamentoMensal) {
      System.out.println("O desconto nao pode ser maior que " + super.pagamentoMensal);
      return false;
    }

    this.desconto = desconto;
    super.setPagamentoMensal(super.getPagamentoMensal() - this.desconto);

    System.out.println("Desconto aplicado com sucesso");
    return true; 
  }

  @Override
  public String mostrarFinanciamentos(int cont) {
    return 
      super.mostrarFinanciamentos(cont) + 
      "\nArea do terreno: " + this.getAreaTerreno() +
      "\nArea construida: " + this.getAreaConstruida() +
      "\nValor do desconto: " + this.desconto +
      "\nValor da mensalidade: " + this.df.format(super.getPagamentoMensal());
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
