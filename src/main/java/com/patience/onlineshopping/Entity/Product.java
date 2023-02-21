package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="PRODUCT")
public class Product {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation

    @Column(name = "PURCHASE_COST")
    private BigDecimal purchaseCost;

    @Column(name = "QUANTITY_ON_HAND")
    private Integer quantityOnHand;

    @Column(name = "MARKUP")
    private BigDecimal markup;


    @Column(name = "AVAILABLE")
    private String available;


    @Column(name = "DESCRIPTION")
    private String description;

    //  @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    //private List<PurchaseOrder> purchaseOrderList;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID")
    @ManyToOne(optional=true,cascade=CascadeType.ALL)
    private Category categoryId;


    @JoinColumn(name = "MANUFACTURER_ID", referencedColumnName = "MANUFACTURER_ID")
    @ManyToOne(optional=true,cascade=CascadeType.ALL)
    private Manufacturer manufacturerId;

    @JoinColumn(name = "PRODUCT_CODE", referencedColumnName = "PROD_CODE")
    @ManyToOne(optional=true,cascade=CascadeType.ALL)
    private ProductCode productCode;
}
