package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProduct();
    void save(Product product);


    void removeProductById(Integer id);
    Optional<Product> findProductById(Integer id);

    Page<Product> findPagenated(int pageNo, int pageSize);
}
