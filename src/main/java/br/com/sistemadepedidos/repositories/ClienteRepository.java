package br.com.sistemadepedidos.repositories;


import br.com.sistemadepedidos.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
