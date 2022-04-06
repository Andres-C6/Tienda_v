package com.tienda.tienda.repository;

import com.tienda.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {

    Persona findByNombre(String nombre);
}
