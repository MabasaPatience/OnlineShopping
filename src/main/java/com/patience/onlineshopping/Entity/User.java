package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data

@Table(name="USER")
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_ID")
    private Integer userId;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;
    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IMAGE")
    private String imageName;

    @JoinColumn(name = "Role", referencedColumnName = "ROLE_ID")
    @ManyToOne(optional = false)
    private Role roleId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private List<Address> addressList;


}