package com.patience.onlineshopping.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer productId;
    private BigDecimal purchaseCost;
    private Integer quantityOnHand;
    private BigDecimal markup;
    private String available;
    private String description;
    private int manufacturerId;
    private int categoryId;
    private int productCodeId;
    private String imageName;
}
