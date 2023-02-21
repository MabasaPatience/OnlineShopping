package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> getAllManufacturer();
    void save(Manufacturer manufacturer);


    void removeManufacturerById(Integer id);
    Optional<Manufacturer> findManufacturerById(Integer id);
}
