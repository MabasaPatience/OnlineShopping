package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
