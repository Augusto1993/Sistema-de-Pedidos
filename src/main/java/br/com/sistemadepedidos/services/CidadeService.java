/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Cidade;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.sistemadepedidos.repositories.CidadeRepository;

/**
 *
 * @author Rafael_Rossales
 */
@Service
public class CidadeService {
    @Autowired
    private CidadeRepository repo;
    
    public List<Cidade>findByEstado(Integer estadoId){
        return repo.findCidades(estadoId);
    }
}
