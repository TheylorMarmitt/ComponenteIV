package br.edu.unoesc.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    private Date data;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exemplar_id")
    private Exemplar exemplar;

    @NotNull
    private Boolean ativo;
    private Integer quantidade;

    // não usado, implementado em service
    public boolean emprestar(Integer qtd){
        this.quantidade += qtd;
        // verifica se exemplar tem quantidade
        if(exemplar.getQuantidadeTotal() >= this.quantidade){
            exemplar.removerQuantidade(this.quantidade);
            setAtivo(true);
            return true;
        }
        return false;
    }

    public boolean devolver(Integer qtd){
        this.quantidade =- qtd;
        if(this.quantidade == 0){
            exemplar.addQuantidade(this.quantidade);
            setAtivo(false);
            return true;
        }
        exemplar.addQuantidade(qtd);
        return false;
    }

    public Emprestimo(@NotNull Date data, @NotNull Pessoa pessoa, @NotNull Exemplar exemplar, @NotNull Boolean ativo, Integer quantidade) {
        this.data = data;
        this.pessoa = pessoa;
        this.exemplar = exemplar;
        this.ativo = ativo;
        this.quantidade = quantidade;
    }

    public Emprestimo(){

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
