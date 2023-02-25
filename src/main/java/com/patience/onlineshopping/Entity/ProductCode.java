package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_CODE")
public class ProductCode {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "PROD_CODE_ID")
    private Integer prodCodeId;

    @Column(name = "PROD_CODE",unique=true)
    private String prodCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCodeId")
    private List<Product> productList;


}
