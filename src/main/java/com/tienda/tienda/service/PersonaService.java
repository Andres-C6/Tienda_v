package com.tienda.tienda.service;

import java.util.List;

import com.tienda.tienda.repository.PersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.tienda.tienda.entity.Persona;

@Service
public class PersonaService implements IPersonaService {

    //Inyeccion de dependencias
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> getAllPerson() {
        return (List<Persona>) personaRepository.findAll();
    }

    @Override
    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona getPersonById(long id) {
        return personaRepository.findById(id).orElse(null);

    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }
    
    
    @Override
    public Persona findByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }
}
