package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "PRODUCT_CODE")
public class ProductCode {
    private static final long serialVersionUID = 1L;
    @Id
    //@Size(min = 1, max = 8)
    @Column(name = "PROD_CODE")
    private String prodCode;

    @Column(name = "DESCRIPTION")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCode")
    private List<Product> productList;
}
