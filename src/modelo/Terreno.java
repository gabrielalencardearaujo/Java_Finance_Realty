package modelo;

public class Terreno extends Financiamento {

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setValorFinanciamento(this.getValorFinanciamento() + (this.getValorFinanciamento() * 0.02));
  }
}
