package br.com.sistemadepedidos.repositories;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer>{

}
