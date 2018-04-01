package br.com.sistemadepedidos.services;


import br.com.sistemadepedidos.domain.Pedido;
import br.com.sistemadepedidos.repositories.PedidoRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {
        Pedido obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!! ID:" + id + ", Tipo: " + Pedido.class.getName());
        }


        return obj;


    }
}
