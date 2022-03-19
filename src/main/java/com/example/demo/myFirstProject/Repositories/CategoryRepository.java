package com.example.demo.myFirstProject.Repositories;

import com.example.demo.myFirstProject.Entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CategoryRepository {

    private Map<Long, Category> map = new HashMap<>();

    public void save(Category obj){ //Método Salva
        map.put(obj.getId(), obj);
    }

    public Category findById(Long id){ //Método buscar unico
        return map.get(id);
    }

    public List<Category> findAll(){ //Método buscar todos
        return new ArrayList<Category>(map.values());
    }

}
