package br.com.sistemadepedidos;

import br.com.sistemadepedidos.services.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaDePedidosApplication implements CommandLineRunner {

    @Autowired
    private S3Service s3Service;

    public static void main(String[] args) {
        SpringApplication.run(SistemaDePedidosApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        s3Service.uploadFile("/home/grazziano/Imagens/511052.jpg");
    }
}