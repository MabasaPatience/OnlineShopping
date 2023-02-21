package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Role> getAllRolls();
    void addRole(Role role);

    void removeRoleById(Integer id);
    Optional<Role> updateRoleById(Integer id);

}
