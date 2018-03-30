package br.com.sistemadepedidos.repositories;

import br.com.sistemadepedidos.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria,Integer>{

}
