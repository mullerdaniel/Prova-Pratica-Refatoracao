package model;

public class Prato {

    private String nome;
    private double preco;
    private int estoque;


    // METODO CONSTRUTOR
    public Prato(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    // GETs E SETs
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    // METODO reduzirEstoque COM PARAMETRO int quantidade
    public void reduzirEstoque(int quantidade) {
        if (quantidade > estoque) throw new IllegalArgumentException("Estoque insuficiente!");
        estoque -= quantidade;
    }

    // METODO adicionarEstoque COM PARAMETRO int quantidade
    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    // @Override com toString
    @Override
    public String toString() {
        return nome + " | R$ " + preco + " | Estoque: " + estoque;
    }
}
