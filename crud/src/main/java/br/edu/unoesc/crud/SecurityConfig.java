package br.edu.unoesc.crud;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;


// nessa classe com @bean -> mapeado pelo spring
// WebSecurityConfigurerAdapter -> da os met. de configuracao
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // noop -> sem operacao, sem criptografia

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("aluno")
                .password("{noop}123")
                .roles("USER","ADMIN")
                .and()
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/aluno/**").hasRole("ALUNO")
                .antMatchers("/**").hasRole("USER")


                .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .loginProcessingUrl("/do_login");

    }


}
