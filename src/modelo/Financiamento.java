package modelo;

public class Financiamento implements InterFinanciamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double valorFinanciamento;
    private double amortizacao;
    private double taxaJurosMensal;

    //Contructor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento * 12;
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
        this.taxaJurosMensal = taxaJurosAnual;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }
}
