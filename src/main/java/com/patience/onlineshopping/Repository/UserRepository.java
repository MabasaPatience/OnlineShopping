package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAllByRoleId(int id);
}
