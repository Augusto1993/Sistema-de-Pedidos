package br.com.sistemadepedidos.repositories;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.domain.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Integer>{
    
@Transactional(readOnly=true)    
public List<Estado> findAllByOrderByNome();
}
