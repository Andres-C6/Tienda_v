
package com.tienda.tienda.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.sterotype.Entity;

@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    
    @GenerateValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;

    @ManyToOne
    @JoinColumn(name = "paises id")
    private Pais pais;

}
