package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Role;
import com.patience.onlineshopping.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements  RoleService{

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRolls() {

        return roleRepository.findAll();
    }

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRoleById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> updateRoleById(Integer id) {
       return roleRepository.findById(id);

    }
}
