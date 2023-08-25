package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;
    private double amortizacao;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double calcPagamentoMensal(){
        return (this.getValorImovel() / this.getPrazoFinanciamento()) * (1 + (this.getTaxaJurosAnual() / 12));
    }

    public double totalPagamento(){
        return this.calcPagamentoMensal() * this.getPrazoFinanciamento();
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public void setTaxaJurosAnual(double taxaJurosAnual) {
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }
}
