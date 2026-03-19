package service;

import model.Pedido;

public class VendaService {

    // METODO processarVenda RETORNANDO UM DOUBLE COM PARAMETRO Pedido pedido
    public double processarVenda(Pedido pedido) {

        // AQUI É UMA VARIAVEL DOUBLE COM valorBase que vai receber / pegar O PREÇO DO PRATO * A QUANTIDADE DE PEDIDOS.
        double valorBase = pedido.getPrato().getPreco() * pedido.getQuantidade();

        // AQUI SE O PEDIDO FOR POR ENTREGA VAI ADICIONAR + 15 "REAIS"
        if (pedido.isEntrega()) {
            valorBase += 15;
            double valorFinal = pedido.getPagamento().calcularValorFinal(valorBase); // AQUI TEMOS UMA VARIAVEL DOUBLE COM valorFinal QUE VAI RECEBER O VALOR O valorBase SO QUE VAI SER ADICIONADO A TAXA DE ENTREGA
            pedido.getPrato().reduzirEstoque(pedido.getQuantidade()); // AQUI ELE VAI REDUZIR 1 DO ESTOQUE
            return valorFinal; // ELE VAI RETORNAR O VALOR FINAL
        }
        return valorBase; // CASO ELE NÃO ENTRE NO IF ELE VAI RETORNAR SOMENTE O valorBase.
    }
}