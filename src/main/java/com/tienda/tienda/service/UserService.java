/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.service;

import com.tienda.tienda.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class UserService implements UserDetailsService{
    
    @Autowired
    public IPersonaService personaService;

    
    /*
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona p= personaService.findByNombre(username);
        List <GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority ("Admin"));
        UserDetails userDet = new User(p.getNombre(), p.getApellido1(), roles);
        return userDet;
    }
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona= this.personaService.findByNombre(username);
        UserPrincipal userPrincipal = new UserPrincipal(persona);
        return userPrincipal;
    }
    
    
    
}
