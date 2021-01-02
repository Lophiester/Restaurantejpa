package com.lophiester.Restaurante;

import com.lophiester.Restaurante.domain.*;
import com.lophiester.Restaurante.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RestauranteApplication implements CommandLineRunner {


    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProvinciaRepository provinciaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private ClienteRepository clienteRepository;

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

        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

        Provincia pro1 = new Provincia(null, "愛知県");
        Provincia pro2 = new Provincia(null, "大阪府");

        provinciaRepository.saveAll(Arrays.asList(pro1, pro2));

        Cidade cid1 = new Cidade(null, "西尾市", pro1);
        Cidade cid2 = new Cidade(null, "日進市", pro1);
        Cidade cid3 = new Cidade(null, "大阪市", pro2);

        pro1.getCidades().addAll(Arrays.asList(cid1, cid2));
        pro2.getCidades().addAll(Arrays.asList(cid3));

        cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

        Cliente cli1 = new Cliente(null, "Carlos Morales", "carlos@gmail.com");
        cli1.getTelefones().addAll(Arrays.asList("08099955"));

        Cliente cli2 = new Cliente(null, "Joao Morales", "joao@gmail.com");
        cli2.getTelefones().addAll(Arrays.asList("05552154"));

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));

        Endereco end1 = new Endereco(null, "下町宮東18－２", "ビレッジハウス4-102", "0804508", cid1, cli1);
        Endereco end2 = new Endereco(null, "上田まち32-25", null, "080-1251", cid1, cli1);
        Endereco end3 = new Endereco(null, "大阪町12-2", "す大阪大学", "415-0802", cid3, cli2);

        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));

    }
}
