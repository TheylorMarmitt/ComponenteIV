package br.edu.unoesc.crud.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements EntidadePersistente {
	
	private static final long serialVersionUID = 4728636547633461131L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotNull
    @NotEmpty(message = "Nome obrigatório")
    @Size(min = 1, max = 150, message = "Nome inválido")
    private String nome;

    @NotEmpty(message = "Sobrenome obrigatório")
    @Size(min = 1, max = 150, message = "Sobrenome inválido")
    private String sobrenome;
    
    @NotNull(message = "Data obrigatória")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @NotNull
    @Email( message = "E-mail inválido")
    @Size(min = 1, message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @NotNull
    @NotEmpty(message = "CPF obrigatório")
    @CPF(message = "CPF inválido")
    private String cpf;

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

	public Pessoa() {

	}

	@Override
	public String toString() {
		return "Pessoa{" + "codigo=" + codigo + ", nome='" + nome + '\'' + ", sobrenome='" + sobrenome + '\''
				+ ", dataNascimento=" + dataNascimento + ", email='" + email + '\'' + ", cpf='" + cpf + '\'' + '}';
	}
}
