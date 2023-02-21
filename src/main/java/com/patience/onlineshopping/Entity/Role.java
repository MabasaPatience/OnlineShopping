package com.patience.onlineshopping.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name="ROLE")
public class Role {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId")
    private List<User> userList;


}
