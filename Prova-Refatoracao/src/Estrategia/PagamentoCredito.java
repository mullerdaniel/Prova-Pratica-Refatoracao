package Estrategia;

public class PagamentoCredito implements PagamentoEstrategia {
    @Override
    public double calcularValorFinal(double valorBase) {
        // VAI RETORNA O valorBase * 1.05 | E COMO É NO CREDITO É 1.05 VEZES O VALOR BASE (AUMENTO)
        return valorBase * 1.05;
    }
}