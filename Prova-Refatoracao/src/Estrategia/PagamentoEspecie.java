package Estrategia;

public class PagamentoEspecie implements PagamentoEstrategia {
    @Override
    public double calcularValorFinal(double valorBase) {
        // VAI RETORNAR O valorBase * 0.92 | E COMO É UM PAGAMENTO ESPECI QUE NO CASO É DINHEIRO FISICO É 0.92 VEZES O VALOR BASE (TERA MAIS DESCONTO DOQUE NO PIX)
        return valorBase * 0.92;
    }
}