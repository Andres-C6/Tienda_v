/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author gerar
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//    @Autowired
//    private UserService userDetailsService;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        //}
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")//si no se usa el passwordEncoder para ecryptar la pass, da error de comprobacion (Bad Password)                                                          //ya que hay missmatch 
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("vendedor")
                .password("{noop}123")//{noop}omite encriptar la contrasena, va al inicio
                .roles("VENDEDOR","USER")
                .and()
                .withUser("user")
                .password("{noop}123")//{noop}omite encriptar la contrasena, va al inicio
                .roles("USER");
                
                
    }
    
    //el siguiente metodo funciona para realizar la autorizacion de accesos. 
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/crear")
                .hasRole("ADMIN")
                .antMatchers("/articulo/listado","/categoria/listado","/cliente/listado")
                .hasAnyRole("ADMIN","USER")
                .antMatchers("/")
                .hasAnyRole("ADMIN","USER","ADMIN")
                .and()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
