package model;

import Estrategia.PagamentoEstrategia;

public class Pedido {

    private Prato prato;
    private int quantidade;
    private boolean entrega;
    private PagamentoEstrategia pagamento;


    // METODO CONSTRUTOR
    public Pedido(Prato prato, int quantidade, boolean delivery, PagamentoEstrategia pagamento) {
        this.prato = prato;
        this.quantidade = quantidade;
        this.entrega = delivery;
        this.pagamento = pagamento;
    }

    // GETs E SETs

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public PagamentoEstrategia getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoEstrategia pagamento) {
        this.pagamento = pagamento;
    }
}