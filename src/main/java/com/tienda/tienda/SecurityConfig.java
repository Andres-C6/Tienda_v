/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda;

import com.tienda.tienda.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author gerar
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    
    private UserDetailsService userDetailsService;
//    @Autowired
//    private UserService userDetailsService;

    /**
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);

        return daoAuthenticationProvider;
    }

    
    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        //}
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")//si no se usa el passwordEncoder para ecryptar la pass, da error de comprobacion (Bad Password)                                                          //ya que hay missmatch 
                .roles("ADMIN", "VENDEDOR", "USER")
                .and()
                .withUser("vendedor")
                .password("{noop}123")//{noop}omite encriptar la contrasena, va al inicio
                .roles("VENDEDOR", "USER")
                .and()
                .withUser("user")
                .password("{noop}123")//{noop}omite encriptar la contrasena, va al inicio
                .roles("USER");

    }
    */

    //el siguiente metodo funciona para realizar la autorizacion de accesos. 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/persona")
                .hasRole("ADMIN")
                .antMatchers("/persona", "/persona")
                .hasAnyRole("USER", "VENDEDOR","ADMIN")
                .antMatchers("/")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .and()
                .formLogin()
                .loginProcessingUrl("/signin").permitAll();
  }
}
 