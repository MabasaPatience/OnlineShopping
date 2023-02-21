package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Category;
import com.patience.onlineshopping.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void removeCategoryById(Integer id) {
        categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> findCategoryById(Integer id) {

        return categoryRepository.findById(id);
    }
}
