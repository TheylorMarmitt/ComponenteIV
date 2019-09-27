package br.edu.unoesc.crud.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Exemplar")
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @NotEmpty(message = "Título obrigatório")
    @Size(min = 1, max = 150, message = "Título inválido")
    private String titulo;

    @NotNull
    @NotEmpty(message = "Autor obrigatório")
    @Size(min = 1, max = 150, message = "Autor inválido")
    private String autor;

    @NotNull
    @NotEmpty(message = "Gênero obrigatório")
    @Size(min = 1, max = 150, message = "Gênero inválido")
    private String genero;

    @NotNull
    @NotEmpty(message = "Editora obrigatória")
    @Size(min = 1, max = 150, message = "Editora inválido")
    private String editora;

    @NotNull(message = "Ano de Publicação obrigatório")
    private Integer anoPublicacao;

    @NotNull(message = "Quantidade obrigatória")
    @Min(value = 1, message = "Quantidade inválida")
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

    @Override
    public String toString() {
        return "Exemplar{" +
                "codigo=" + codigo +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", editora='" + editora + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", quantidadeTotal=" + quantidadeTotal +
                '}';
    }
}
