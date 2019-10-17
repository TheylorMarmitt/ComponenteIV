package br.edu.unoesc.crud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Devolucao")
public class Devolucao implements EntidadePersistente {

	private static final long serialVersionUID = -3444001196821052650L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull(message = "Data inválida")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @NotNull(message = "Emprestimo obrigatório")
    @ManyToOne
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;

    @NotNull(message = "Quantidade obrigatória")
    private Integer quantidade;

    public Devolucao(@NotNull Date data, @NotNull Emprestimo emprestimo, @NotNull Integer quantidade) {
        this.data = data;
        this.emprestimo = emprestimo;
        this.quantidade = quantidade;
    }

    public Devolucao(){

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

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Integer getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade){
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Devolucao{" +
                "codigo=" + codigo +
                ", data=" + data +
                ", emprestimo=" + emprestimo +
                ", quantidade=" + quantidade +
                '}';
    }
}
