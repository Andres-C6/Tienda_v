/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.entity;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ancar
 */
@Entity
@Table(name = "paises")
public class Pais implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pais;

    public long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setId(long i) {
        this.id = i;
    }

    public void setPais(String p) {
        this.pais = p;
    }
}
