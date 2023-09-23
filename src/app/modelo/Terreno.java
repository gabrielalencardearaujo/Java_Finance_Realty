package app.modelo;

public class Terreno extends Financiamento {

  private String zona;

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setZona(zona);
    this.setValorFinanciamento(this.getValorFinanciamento() + (this.getValorFinanciamento() * 0.02));
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona;
  }
}
