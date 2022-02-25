
package com.tienda.tienda.service;

import java.util.list;
import java.util.Optional;
import com.tienda.tienda.service.IPersonaService;
import com.tienda.tienda.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PersonaService implements IPersonaService{
    //Inyeccion de dependencias
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List <Persona> getAllPerson(){
    return (List<Persona>)personaRepository.findAll();
    }
    
}
