package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.ProductCode;
import com.patience.onlineshopping.Repository.ProductCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductCodeServiceImpl implements ProductCodeService{
@Autowired
private ProductCodeRepository productCodeRepository;
    @Override
    public List<ProductCode> getAllProductCode() {
        return productCodeRepository.findAll();
    }

    @Override
    public void save(ProductCode productCode) {
    productCodeRepository.save(productCode);
    }

    @Override
    public void removeProductCodeById(Integer id) {
        productCodeRepository.deleteById(id);
    }

    @Override
    public Optional<ProductCode> findProductCodeById(Integer id) {

        return productCodeRepository.findById(id);
    }
}
