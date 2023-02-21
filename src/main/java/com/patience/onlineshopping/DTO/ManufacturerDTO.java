package com.patience.onlineshopping.DTO;

import lombok.Data;

@Data
public class ManufacturerDTO {

    private Integer manufacturerId;
    private String name;
    private String addressline1;
    private String addressline2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String rep;
}
