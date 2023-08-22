package com.deyvidsalvatore.easybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deyvidsalvatore.easybank.model.Customer;
import com.deyvidsalvatore.easybank.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	CustomerRepository customerRepository;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
		Customer savedCustomer = null;
		ResponseEntity<String> response = null;
		
		try {
			savedCustomer = customerRepository.save(customer);
			if(savedCustomer.getId() > 0) {
				response = ResponseEntity.status(HttpStatus.CREATED).body("Given user details successfully registered");
			}
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception ocurred due to: " + e.getMessage());
		}
		return response;
	}
}
