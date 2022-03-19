package com.example.demo.myFirstProject.Resources;

import com.example.demo.myFirstProject.Entities.Category;
import com.example.demo.myFirstProject.Entities.Product;
import com.example.demo.myFirstProject.Repositories.CategoryRepository;
import com.example.demo.myFirstProject.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define que será um recurso Rest
@RequestMapping("/product") //Define o caminho pelo qual vai responder
public class ProductResources {

    //Injeção de dependência
    @Autowired
    private ProductRepository productRepository;

    //Busca Uma lista
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){ //ResponseEntity, Encapsula a resposta http
        List<Product> list = productRepository.findAll(); //acessa os dados e devolve.
        return ResponseEntity.ok().body(list); //Retorna Resposta OK
    }

    //Busca por id
    //PathVariable reconhece o valor do id
    @GetMapping("/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id){ //Busca apenas um
        Product product = productRepository.findById(id).get(); //acessa os dados e devolve.
        return ResponseEntity.ok().body(product);
    }

}