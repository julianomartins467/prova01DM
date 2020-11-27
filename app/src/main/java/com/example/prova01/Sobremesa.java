package com.example.prova01;

public class Sobremesa {

    private String produto;
    private String descricao;
    private String valor;


    public Sobremesa(String produto, String descricao, String valor) {
        this.produto = produto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto: " + getProduto()
                + "\nDescrição: " + getDescricao()
                + "\nValor: " + getValor();
    }
}
