package com.example.demo.myFirstProject.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Entity //Anotação de entidade gerenciada pelo jpa
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incrementado no db
    private Long id;
    private String name;
    private Double price;


    @ManyToOne //Relacionamentos de objetos na memória Muitos pra um
    @JoinColumn(name = "category_id") //corresponde a chave estrageira do db relacional
    private Category category;
}
