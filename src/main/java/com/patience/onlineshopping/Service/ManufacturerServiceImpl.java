package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Manufacturer;
import com.patience.onlineshopping.Repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ManufacturerServiceImpl implements  ManufacturerService{
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }

    @Override
    public void save(Manufacturer manufacturer) {

        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void removeManufacturerById(Integer id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Optional<Manufacturer> findManufacturerById(Integer id) {
        return manufacturerRepository.findById(id);
    }
}
