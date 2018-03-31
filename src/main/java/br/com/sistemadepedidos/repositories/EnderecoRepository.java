package br.com.sistemadepedidos.repositories;


import br.com.sistemadepedidos.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{

}
