package com.lophiester.Restaurante;

import com.lophiester.Restaurante.domain.Categoria;
import com.lophiester.Restaurante.domain.Produto;
import com.lophiester.Restaurante.repositories.CategoriaRepository;
import com.lophiester.Restaurante.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestauranteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria(null, "Pratos");
        Categoria cat2 = new Categoria(null, "Bebidas");
        Categoria cat3 = new Categoria(null, "Lanches");
        Categoria cat4 = new Categoria(null, "Sobremesas");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

        Produto p1 = new Produto(null, "arroz com feijao", 2000L);
        Produto p2 = new Produto(null, "macarrao", 1000L);
        Produto p3 = new Produto(null, "lazanha", 950L);
        Produto p4 = new Produto(null, "guarana", 250L);
        Produto p5 = new Produto(null, "brigadeiro", 400L);
        Produto p6 = new Produto(null, "pastel", 500L);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProdutos().addAll(Arrays.asList(p4));
        cat3.getProdutos().addAll(Arrays.asList(p6));
        cat4.getProdutos().addAll(Arrays.asList(p5));

        p1.getCategorias().addAll(Arrays.asList(cat1));
        p2.getCategorias().addAll(Arrays.asList(cat1));
        p3.getCategorias().addAll(Arrays.asList(cat1));
        p4.getCategorias().addAll(Arrays.asList(cat2));
        p5.getCategorias().addAll(Arrays.asList(cat4));
        p6.getCategorias().addAll(Arrays.asList(cat3));

        produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));



    }
}
