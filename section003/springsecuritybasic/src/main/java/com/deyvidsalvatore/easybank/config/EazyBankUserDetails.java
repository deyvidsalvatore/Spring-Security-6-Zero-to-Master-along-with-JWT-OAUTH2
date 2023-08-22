package com.deyvidsalvatore.easybank.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deyvidsalvatore.easybank.model.Customer;
import com.deyvidsalvatore.easybank.repository.CustomerRepository;

@Service
public class EazyBankUserDetails implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		@SuppressWarnings("unused")
		String userName, password = null;
		
		List<GrantedAuthority> authorities = null;
		List<Customer> customer = customerRepository.findByEmail(username);
		
		if(customer.isEmpty()) {
			throw new UsernameNotFoundException("User details not found for the user: " + username);
		} else {
			userName = customer.get(0).getEmail();
			password = customer.get(0).getPwd();
			authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
		}
		return new User(username, password, authorities);
	}
	

}
