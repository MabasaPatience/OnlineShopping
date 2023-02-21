package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.ProductCode;

import java.util.List;
import java.util.Optional;

public interface ProductCodeService {
    List<ProductCode> getAllProductCode();
    void save(ProductCode productCode);
    void removeProductCodeById(Integer id);
    Optional<ProductCode> findProductCodeById(Integer id);
}
