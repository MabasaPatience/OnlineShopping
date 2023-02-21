package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
@Entity
@Table(name="ADDRESS")
public class Address {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ADDRESS_ID")
    private Integer roleId;


    @Column(name = "STREETADDRESS")
    private String addressline1;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Column(name = "PROVINCE")
    private String province;

    @JoinColumn(name = "User_ID", referencedColumnName = "User_ID")
    @ManyToOne(optional = false)
    private User userid;


}
