package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {


}
