package br.com.sistemadepedidos;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.domain.Produto;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import br.com.sistemadepedidos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Categoria cat1 = new Categoria( null, "Informáica");
        Categoria cat2 = new Categoria(null,"Escritório");

        Produto p1 = new Produto(null,"Computador" ,2000.00 );
        Produto p2 = new Produto(null,"impressora",800.00);
        Produto p3 = new Produto(null,"mouse",80.00);

        cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
        cat2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
        p3.getCategorias().addAll(Arrays.asList(cat1));

        categoriaRepository.save(Arrays.asList(cat1,cat2));
        produtoRepository.save(Arrays.asList(p1,p2,p3));





    }
}
