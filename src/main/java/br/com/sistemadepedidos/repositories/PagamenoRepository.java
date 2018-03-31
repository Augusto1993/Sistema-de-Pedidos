package br.com.sistemadepedidos.repositories;



import br.com.sistemadepedidos.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamenoRepository extends JpaRepository<Pagamento, Integer> {
}
