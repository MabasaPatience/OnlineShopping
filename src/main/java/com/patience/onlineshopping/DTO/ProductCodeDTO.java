package com.patience.onlineshopping.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCodeDTO {
    private Integer prodCodeId;
    private String prodCode;
    private String description;
}
