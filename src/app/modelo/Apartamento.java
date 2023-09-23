package app.modelo;

public class Apartamento extends Financiamento {
  private int vagasGaragem, andarApartamento;

  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int andarApartamento) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.setVagasGaragem(vagasGaragem);
    this.setAndarApartamento(andarApartamento);
  }

  @Override
  public double totalPagamento(){
    double valorTotalPagamento = 0;
    for (int i = 1; i <= super.getPrazoFinanciamento() *12; i++) {
      valorTotalPagamento +=
        this.pagamentoMensal + (this.pagamentoMensal * (1 / i / 100));
    }
    return valorTotalPagamento;
  }

  @Override
  public void mostrarFinanciamentos(int cont) {
    super.mostrarFinanciamentos(cont);  
    System.out.println("-> Tipo do Financiamento: APARTAMENTO <-");
    System.out.println("Vagas na Garagem: " + this.getVagasGaragem());
    System.out.println("Andar do Apartamento: " + this.getAndarApartamento());
  }

  //Getters e Setters:

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
