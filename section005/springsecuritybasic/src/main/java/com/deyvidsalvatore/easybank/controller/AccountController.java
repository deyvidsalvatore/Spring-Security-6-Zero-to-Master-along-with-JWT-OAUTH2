package com.deyvidsalvatore.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@GetMapping("/myAccount")
	public String getAccountDetails() {
		return "Here the account from DB";
	}

}
