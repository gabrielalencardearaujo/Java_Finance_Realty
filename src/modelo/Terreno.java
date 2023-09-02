package modelo;

public class Terreno extends Financiamento {

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setTaxaJurosAnual((this.getTaxaJurosMensal() * 12) + 2);
  }
}
