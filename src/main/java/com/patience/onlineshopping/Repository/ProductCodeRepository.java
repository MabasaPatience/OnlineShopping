package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.ProductCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCodeRepository extends JpaRepository <ProductCode,Integer> {
}
