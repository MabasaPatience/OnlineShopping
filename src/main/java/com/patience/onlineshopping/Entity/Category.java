package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="CATEGORY")
public class Category {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Integer categoryId;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private List<Product> productList;

}
