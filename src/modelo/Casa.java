package modelo;


public class Casa extends Financiamento {
   public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    
  }

  public void descontoParcela(double desconto) {
    this.setPagamentoMensal(this.getPagamentoMensal() - desconto);
    System.out.println("Desconto da parcela da Casa " + desconto + " realizado com sucesso!");
  }
}
