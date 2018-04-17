package br.com.sistemadepedidos.services;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.domain.Produto;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import br.com.sistemadepedidos.repositories.ProdutoRepository;
import br.com.sistemadepedidos.services.exceptions.ObjectNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto find(Integer id) {
        Produto obj = repo.findOne(id);
        if (obj == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!! ID: " + id + ", Tipo: " + Produto.class.getName());
        }

        return obj;

    }

    /*Busca Paginada*/
    public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage,
            String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage,
                Sort.Direction.valueOf(direction), orderBy);
        List<Categoria> categorias = categoriaRepository.findAll(ids);
        return repo.search(nome, categorias, pageRequest);
    }
}
