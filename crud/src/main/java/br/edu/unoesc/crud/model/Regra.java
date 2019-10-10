package br.edu.unoesc.crud.model;

public enum Regra {

	USER {
		@Override
		String getRegra() {
			return "ROLE_USER";
		}
	},
	ADMIN{
		@Override
		String getRegra() {
			return "ROLE_ADMIN";
		}
	};

	abstract String getRegra();
	
}
