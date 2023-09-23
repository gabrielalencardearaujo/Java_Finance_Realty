package app.modelo;

public class Terreno extends Financiamento {

  private String zona;

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setZona(zona);
    this.setValorFinanciamento(this.getValorFinanciamento() + (this.getValorFinanciamento() * 0.02));
  }

  @Override 
  public String mostrarFinanciamentos(int cont) {
    return 
      super.mostrarFinanciamentos(cont) + 
      "\nTipo de Terreno: " + this.getZona();
  }

  public String getZona() {
    return zona;
  }

  public void setZona(String zona) {
    this.zona = zona.toUpperCase();
  }
}
