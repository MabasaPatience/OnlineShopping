package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();
    public void saveuser(User user);
    void deleteUserById(int id);

     Optional<User> findUserById(int id);

     List<User> getAllUsersByUserByRole(int id);
}
