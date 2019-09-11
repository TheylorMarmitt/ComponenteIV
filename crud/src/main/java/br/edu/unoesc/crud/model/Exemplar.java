package br.edu.unoesc.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private String titulo;

    @NotNull
    private String autor;

    private String genero;
    private String editora;
    private Integer anoPublicacao;

    private Integer quantidadeTotal;

    public void addQuantidade(Integer quantidade){
        if(this.quantidadeTotal == null){
            this.quantidadeTotal = 0;
        }
        this.quantidadeTotal += quantidade;
    }

    public boolean removerQuantidade(Integer quantidade){
        if(this.quantidadeTotal >= quantidade){
            this.quantidadeTotal -= quantidade;
            return true;
        }
        return false;
    }

    public Exemplar(){

    }

    public Exemplar(Long codigo, String titulo, String autor, String genero, String editora,
                    Integer anoPublicacao,  Integer quantidadeTotal) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeTotal = quantidadeTotal;
    }

    public void devolver(Integer quantidade){
        this.quantidadeTotal += quantidade;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Integer getQuantidadeTotal() {
        return quantidadeTotal;
    }

    public void setQuantidadeTotal(Integer quantidadeTotal) {
        this.quantidadeTotal = quantidadeTotal;
    }
}
