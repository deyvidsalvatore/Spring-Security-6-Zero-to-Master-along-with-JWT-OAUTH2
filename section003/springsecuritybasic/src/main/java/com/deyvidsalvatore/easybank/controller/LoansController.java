package com.deyvidsalvatore.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
	
	@GetMapping("/myLoans")
	public String getLoanDetails() {
		return "Here the Loan from DB";
	}

}
