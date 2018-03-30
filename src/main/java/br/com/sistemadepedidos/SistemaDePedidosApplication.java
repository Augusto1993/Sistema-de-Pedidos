package br.com.sistemadepedidos;

import br.com.sistemadepedidos.domain.Categoria;
import br.com.sistemadepedidos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SistemaDePedidosApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Categoria cat1 = new Categoria( null, "Informáica");
        Categoria cat2 = new Categoria(null,"Escritório");
        categoriaRepository.save(Arrays.asList(cat1,cat2));




    }
}
