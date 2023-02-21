package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.User;
import com.patience.onlineshopping.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveuser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(int id) {
            userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsersByUserByRole(int id) {
        return userRepository.findAllByRoleId(id);
    }
}
