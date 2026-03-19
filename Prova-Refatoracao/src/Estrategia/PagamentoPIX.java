package Estrategia;

public class PagamentoPIX implements PagamentoEstrategia {
    @Override
    public double calcularValorFinal(double valorBase) {
        // VAI RETORNAR O valorBase * 0.9 | E COMO É NO PIX É 0.9 VEZES O VALOR BASE (DESCONTO)
        return valorBase * 0.9;
    }
}