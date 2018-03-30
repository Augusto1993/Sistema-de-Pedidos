package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id){
    Categoria obj = repo.findOne(id);
    return obj;
    }
}
