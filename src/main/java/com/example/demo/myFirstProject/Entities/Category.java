package com.example.demo.myFirstProject.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incrementado no db
    private Long id;
    private String name;

    //Assossiação 1 categoria tem vários produtos
    @JsonIgnore //Não serializa a lista de produtos de uma categoria
    @OneToMany (mappedBy = "category") //Relacionamentos de objetos na memória um pra muitos
    private List<Product> products = new ArrayList<>();
}
