package br.com.sistemadepedidos;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.domain.Cidade;
import br.com.sistemadepedidos.domain.Estado;
import br.com.sistemadepedidos.domain.Produto;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import br.com.sistemadepedidos.repositories.CidadeRepository;
import br.com.sistemadepedidos.repositories.EstadoRepository;
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
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    EstadoRepository estadoRepository;

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

        Estado est1 = new Estado(null,"Rio Grande Do Sul");
        Estado est2 = new Estado(null,"Santa Catarina");

        Cidade c1 = new Cidade(null,"Pelotas",est1);
        Cidade c2 = new Cidade(null, "Florianópolis",est2);
        Cidade c3 = new Cidade(null,"Rio Grande",est1);

        est1.getCidades().addAll(Arrays.asList(c1,c3));
        est2.getCidades().addAll(Arrays.asList(c2));

        estadoRepository.save(Arrays.asList(est1,est2));
        cidadeRepository.save(Arrays.asList(c1,c2,c3));





    }
}
