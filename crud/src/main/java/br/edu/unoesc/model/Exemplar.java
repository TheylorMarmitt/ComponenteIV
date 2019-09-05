package br.edu.unoesc.model;

import javax.persistence.Entity;

public class Exemplar {

    private String titulo;
    private String autor;
    private String genero;
    private String editora;
    private Integer anoPublicacao;
    private Integer quantidadeTotal;

    public void addQuantidade(Integer quantidade){
        if(this.quantidadeTotal == null){
            this.quantidadeTotal = 0;
        }
        this.quantidadeTotal = this.quantidadeTotal + quantidade;
    }

    public boolean emprestar(Integer quantidade){
        if(this.quantidadeTotal >= quantidade){
            this.quantidadeTotal = this.quantidadeTotal - quantidade;
            return true;
        }else {
            return false;
        }
    }


}
