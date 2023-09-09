package modelo;

public abstract class Financiamento implements InterFinanciamento {
    protected double valorImovel, valorFinanciamento, amortizacao, taxaJurosMensal, pagamentoMensal, taxaJurosAnual;
    protected int prazoFinanciamento, mensalidadeAtual;

    // Contructor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.mensalidadeAtual = 1;
        this.taxaJurosAnual = taxaJurosAnual;
        this.taxaJurosMensal = taxaJurosAnual / 12;
    }

    // Metodos Personalizados
    public double calcPagamentoMensal() {
        this.valorFinanciamento = this.getValorImovel() * this.getTaxaJurosAnual();
        this.setPagamentoMensal((this.getValorImovel() / this.getPrazoFinanciamento()) / (1 + (this.getTaxaJurosAnual() / 12)));

        return this.getPagamentoMensal();
    }

    public double totalPagamento() {
        return this.calcPagamentoMensal() * this.getPrazoFinanciamento();
    }

    public void pagarMensalidade() {
        this.mensalidadeAtual++;
        System.out.println("Mensalidade " + this.getMensalidadeAtual() + "no valor de " + this.getPagamentoMensal() + "paga com sucesso n");
    }

    // Metodos Especiais
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

    public void setTaxaJurosMensal(double taxaJurosAnual) {
        this.taxaJurosMensal = taxaJurosAnual / 12;
    }

    public void setValorImovel(double valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setPagamentoMensal(double novoPagamento) {
        if (novoPagamento > 0) {
            this.pagamentoMensal = novoPagamento;
        }
    }

    public double getPagamentoMensal() {
        return this.pagamentoMensal;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public void setTaxaJurosAnual(double novaTaxa) {
        this.taxaJurosAnual = novaTaxa;
    }

    public int getMensalidadeAtual() {
        return this.mensalidadeAtual;
    }

    public double getValorFinanciamento() {
        return this.valorFinanciamento;
    }
    public void setValorFinanciamento(double novoValor) {
        this.valorFinanciamento = novoValor;
    }
}
