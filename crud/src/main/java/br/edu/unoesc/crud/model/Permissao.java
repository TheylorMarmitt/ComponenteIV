package br.edu.unoesc.crud.model;

import static br.edu.unoesc.crud.model.Regra.USER;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "REGRA")
public class Permissao implements GrantedAuthority {

	private static final long serialVersionUID = -5638167253967450925L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long codigo;

	@Enumerated(EnumType.STRING)
	private Regra regra = USER;

	@Override
	public String getAuthority() {
		return this.regra.getRegra();
	}

	public Permissao(Regra regra) {
		this.regra = regra;
	}

	public Permissao() {
	}

}
