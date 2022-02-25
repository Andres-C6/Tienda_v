
package com.tienda.tienda.service;
import java.util.list;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface IPersonaService {
    public List<Persona> getAllPerson();
    public void savePerson (Persona persona);
    public Persona getPersonById(long id);
    public void delete (long id);
    
}
