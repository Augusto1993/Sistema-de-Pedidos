package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Cliente;
import br.com.sistemadepedidos.repositories.ClienteRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {
        Cliente obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!! ID:" + id + ", Tipo: " + Cliente.class.getName());
        }


        return obj;


    }
}
