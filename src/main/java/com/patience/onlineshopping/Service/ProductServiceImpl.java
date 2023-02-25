package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Product;
import com.patience.onlineshopping.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void removeProductById(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findPagenated(int pageNo, int pageSize) {
        return null;
    }

}
