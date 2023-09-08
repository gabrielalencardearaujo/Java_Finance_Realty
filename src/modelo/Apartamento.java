package modelo;

public class Apartamento extends Financiamento {

  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.recalculoTaxaAnual();
  }

  private void recalculoTaxaAnual() {
    double novaTaxaRecalculada = (this.getTaxaJurosMensal() * 12) - (1 / (this.getMensalidadeAtual() * 12));
    this.setTaxaJurosAnual(novaTaxaRecalculada);
  }
}
