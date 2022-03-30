/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.tienda.repository;

import java.util.List;
import java.util.Optional;
import com.tienda.tienda.entity.Pais;

/**
 *
 * @author ancar
 */

@Service
public class PaisService {
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry(){
        return (List<Pais>) paisRepository.findAll();
    }
}
