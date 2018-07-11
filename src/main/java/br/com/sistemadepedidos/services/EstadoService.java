/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Estado;
import br.com.sistemadepedidos.repositories.EstadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael_Rossales
 */
@Service
public class EstadoService {
    
    @Autowired
    private EstadoRepository repo;
    
    
    public List<Estado> findAll(){
        return repo.findAllByOrderByNome();
    }
}
