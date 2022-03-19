package com.example.demo.myFirstProject.Resources;

import com.example.demo.myFirstProject.Entities.Category;
import com.example.demo.myFirstProject.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Define que será um recurso Rest
@RequestMapping("/categories") //Define o caminho pelo qual vai responder
public class CategoryResources {

    //Injeção de dependência
    @Autowired
    private CategoryRepository categoryRepository;

    //Busca Uma lista
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){ //ResponseEntity, Encapsula a resposta http
        List<Category> list = categoryRepository.findAll(); //acessa os dados e devolve.
        return ResponseEntity.ok().body(list); //Retorna Resposta OK
    }

    //Busca por id
    //PathVariable reconhece o valor do id
    @GetMapping("/{id}")
    public ResponseEntity<Category> findByID(@PathVariable Long id){ //Busca apenas um
        Category category = categoryRepository.findById(id); //acessa os dados e devolve.
        return ResponseEntity.ok().body(category);
    }

}
