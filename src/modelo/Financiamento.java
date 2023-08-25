package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double valorFinanciamento;
    private double amortizacao;
    private double taxaJurosMensal;

    //Contructor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosMensal = taxaJurosAnual / 12;
    }

    //Metodos Personalizados
    public double calcPagamentoMensal(){
        this.valorFinanciamento = this.getValorImovel() *  this.getTaxaJurosMensal();
        return (this.getValorImovel() + this.valorFinanciamento) / this.getPrazoFinanciamento();
    }

    public double totalPagamento(){
        return this.calcPagamentoMensal() * this.getPrazoFinanciamento();
    }

    public double getValorAmortizacao() {
        this.amortizacao = this.getValorImovel() / this.getPrazoFinanciamento();
        return this.amortizacao;
    }


    //Metodos Especiais
    public double getTaxaJurosMensal() {
        return this.taxaJurosMensal;
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
        this.taxaJurosMensal = taxaJurosAnual;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }
}
