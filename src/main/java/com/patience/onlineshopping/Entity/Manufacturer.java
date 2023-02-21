package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "MANUFACTURER")
public class Manufacturer {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "MANUFACTURER_ID")
    private Integer manufacturerId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESSLINE1")
    private String addressline1;

    @Column(name = "ADDRESSLINE2")
    private String addressline2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP")
    private String zip;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation

    @Column(name = "PHONE")
    private String phone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation



    @Column(name = "EMAIL")
    private String email;

    @Column(name = "REP")
    private String rep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturerId")
    private List<Product> productList;
}
