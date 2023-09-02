package modelo;

public class Financiamento implements InterFinanciamento {
    protected double valorImovel, valorFinanciamento, amortizacao, taxaJurosMensal, pagamentoMensal;
    protected int prazoFinanciamento;

    //Contructor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento * 12;
        this.taxaJurosMensal = taxaJurosAnual / 12;
    }

    //Metodos Personalizados
    public double calcPagamentoMensal(){
        this.valorFinanciamento = this.getValorImovel() *  this.getTaxaJurosMensal();
        this.setPagamentoMensal((this.getValorImovel() + this.valorFinanciamento) / this.getPrazoFinanciamento());
        return this.getPagamentoMensal();
    }

    public double totalPagamento(){
        return this.calcPagamentoMensal() * this.getPrazoFinanciamento();
    }


    //Metodos Especiais
    public double getValorAmortizacao() {
        this.amortizacao = this.getValorImovel() / this.getPrazoFinanciamento();
        return this.amortizacao;
    }

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
        this.taxaJurosMensal = taxaJurosAnual / 12;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setPagamentoMensal(double novoPagamento) {
        this.pagamentoMensal = novoPagamento;
    }

    public double getPagamentoMensal() {
        return this.pagamentoMensal;
    }
}
