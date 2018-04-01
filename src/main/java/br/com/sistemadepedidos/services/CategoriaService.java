package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Categoria obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!! ID:" + id + ", Tipo: " + Categoria.class.getName());
        }


        return obj;


    }
}
