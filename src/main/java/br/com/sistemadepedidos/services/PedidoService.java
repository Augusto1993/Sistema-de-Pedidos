package br.com.sistemadepedidos.services;


import br.com.sistemadepedidos.domain.Pedido;
import br.com.sistemadepedidos.repositories.PedidoRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {

     //  if (obj == null) {
        throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id +
        ", Tipo: " + Pedido.class.getName());
       }
//        return obj.orElseThrow(() -> new ObjectNotFoundException(
             //   "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }


