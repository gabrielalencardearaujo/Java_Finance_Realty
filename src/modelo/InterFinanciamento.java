package modelo;

public interface InterFinanciamento {
  public abstract double calcPagamentoMensal();
  public abstract double totalPagamento();
  public abstract double getValorAmortizacao();
  public abstract double getTaxaJurosMensal();
  public abstract double getValorImovel();
  public abstract int getPrazoFinanciamento();
  public abstract void setPrazoFinanciamento(int var);
  public abstract void setValorImovel(double var);
  public abstract void setTaxaJurosAnual(double var);
}
