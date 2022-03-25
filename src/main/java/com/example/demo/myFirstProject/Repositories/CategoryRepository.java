package com.example.demo.myFirstProject.Repositories;

import com.example.demo.myFirstProject.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}