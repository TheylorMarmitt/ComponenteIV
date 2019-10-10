package br.edu.unoesc.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import br.edu.unoesc.crud.security.UsuarioBancoService;

// nessa classe com @bean -> mapeado pelo spring
// WebSecurityConfigurerAdapter -> da os met. de configuracao
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// noop -> sem operacao, sem criptografia
	@Autowired
	private UsuarioBancoService usuarioBancoService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123")
//                .roles("USER","ADMIN")
//                .and()
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
		auth.userDetailsService(usuarioBancoService)
				.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/pessoa/lista").hasRole("ADMIN")
				.antMatchers("/pessoa/cadastro/**").hasRole("ADMIN")
				.antMatchers("/pessoa/excluir").hasRole("ADMIN")
				.antMatchers("/css/**", "/demo/**", "/js/**", "/img/**", "/scss/**", "/fonts/**").permitAll()
				.antMatchers("/**").permitAll()
				.and().formLogin().loginPage("/login").permitAll().loginProcessingUrl("/do_login");

	}

}
