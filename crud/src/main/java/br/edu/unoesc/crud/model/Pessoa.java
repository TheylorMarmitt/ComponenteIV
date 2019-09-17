package br.edu.unoesc.crud.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.unoesc.crud.reflection.CampoTela;

import java.util.Date;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @CampoTela
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @CampoTela
    private String nome;
    @NotNull
    @CampoTela
    private String sobrenome;
    
    @NotNull
    @CampoTela
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @NotNull
    @CampoTela
    private String email;

    @NotNull(message="CPF obrigatório")
    @Size(min = 11, max = 11, message = "CPF inválido")
    private String cpf;

    public Pessoa() {
    	
    }
    public Pessoa(Long codigo) {
    	
    }
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


	public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pessoa(String nome, String sobrenome, Date dataNascimento, String email, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.cpf = cpf;
    }
}
