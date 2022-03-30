/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.service;

import java.util.List;
import java.util.Optional;
import com.tienda.tienda.entity.Pais;
import com.tienda.tienda.repository.PaisRepository;
import com.tienda.tienda.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ancar
 */

@Service
public class PaisService implements IPaisService{
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry(){
        return (List<Pais>) paisRepository.findAll();
    }
}
