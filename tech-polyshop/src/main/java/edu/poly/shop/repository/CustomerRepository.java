package edu.poly.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.poly.shop.domain.Customer;
import edu.poly.shop.domain.Customer1;
import edu.poly.shop.model.CustomerDto;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer1, String>{

}
