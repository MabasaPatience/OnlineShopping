package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
