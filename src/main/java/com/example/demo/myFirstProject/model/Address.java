package com.example.demo.myFirstProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cep;
    private String logradouro;
    private Integer number;
    private String bairro;
    private String localidade;
    private String uf;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<User> products = new ArrayList<>();
}
