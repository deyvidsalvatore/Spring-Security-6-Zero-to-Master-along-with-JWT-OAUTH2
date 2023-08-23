package com.deyvidsalvatore.easybank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.deyvidsalvatore.easybank.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByEmail(String email);
}
