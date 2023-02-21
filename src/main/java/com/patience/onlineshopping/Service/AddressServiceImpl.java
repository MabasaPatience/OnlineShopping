package com.patience.onlineshopping.Service;

import com.patience.onlineshopping.Entity.Address;
import com.patience.onlineshopping.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAdress() {

        return addressRepository.findAll();

    }
}
