package com.patience.onlineshopping.Repository;

import com.patience.onlineshopping.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address,Integer> {
}
