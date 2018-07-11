/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.resources;

import br.com.sistemadepedidos.domain.Cidade;
import br.com.sistemadepedidos.domain.Estado;
import br.com.sistemadepedidos.dto.CidadeDTO;
import br.com.sistemadepedidos.dto.EstadoDTO;
import br.com.sistemadepedidos.services.CidadeService;
import br.com.sistemadepedidos.services.EstadoService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael_Rossales
 */
@RestController
@RequestMapping(value="/estados")
public class EstadoResource {
    @Autowired
    private EstadoService service;
    
    private CidadeService cidadeService;
    
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<EstadoDTO>>findAll(){
        List<Estado> list = service.findAll();
        List<EstadoDTO> listDto = list.stream().map(obj -> new EstadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
        
    }
    
       
    @RequestMapping(value="/{estadoId}/cidades",method=RequestMethod.GET)
    public ResponseEntity<List<CidadeDTO>>findCidades(@PathVariable Integer estadoId){
        List<Cidade> list = cidadeService.findByEstado(estadoId);
        List<CidadeDTO> listDto = list.stream().map(obj -> new CidadeDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
        
    }
    
    
}
