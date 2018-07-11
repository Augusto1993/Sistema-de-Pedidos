/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.dto;

import br.com.sistemadepedidos.domain.Estado;

/**
 *
 * @author Rafael_Rossales
 */
public class EstadoDTO {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;

    public EstadoDTO() {
    }
    
    public EstadoDTO(Estado obj) {
        id=obj.getId();
        nome=obj.getNome();
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
