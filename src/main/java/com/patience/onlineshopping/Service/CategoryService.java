package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getAllCategory();
    void save(Category category);


    void removeCategoryById(Integer id);
    Optional<Category> findCategoryById(Integer id);
}
