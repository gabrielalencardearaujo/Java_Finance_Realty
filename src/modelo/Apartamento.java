package modelo;

public class Apartamento extends Financiamento {
  private int vagasGaragem, andarApartamento;

  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andarApartamento) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setVagasGaragem(vagasGaragem);
    this.setAndarApartamento(andarApartamento);
    this.recalculoTaxaAnual();
  }

  private void recalculoTaxaAnual() {
    double novaTaxaRecalculada = (this.getTaxaJurosMensal() * 12) - (1 / (this.getMensalidadeAtual() * 12));
    this.setTaxaJurosAnual(novaTaxaRecalculada);
  }

  public int getVagasGaragem() {
    return vagasGaragem;
  }

  public void setVagasGaragem(int vagasGaragem) {
    this.vagasGaragem = vagasGaragem;
  }

  public int getAndarApartamento() {
    return andarApartamento;
  }

  public void setAndarApartamento(int andarApartamento) {
    this.andarApartamento = andarApartamento;
  }
}
