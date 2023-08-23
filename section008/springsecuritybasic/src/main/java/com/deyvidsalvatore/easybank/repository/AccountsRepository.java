package com.deyvidsalvatore.easybank.repository;

import com.deyvidsalvatore.easybank.model.Accounts;
import com.eazybytes.model.Accounts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	
	Accounts findByCustomerId(int customerId);

}
