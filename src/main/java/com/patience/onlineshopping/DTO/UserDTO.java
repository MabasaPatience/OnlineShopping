package com.patience.onlineshopping.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private int userId;
    private String firstname;
    private String lastname;
    private String gender;
    private String password;
    private String password2;
    private String phone;
    private String email;
    private int roleId;
    private String imageName;

}
