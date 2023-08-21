package com.deyvidsalvatore.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class CardsController {
	
	@GetMapping("/myCards")
	public String getCardsDetails() {
		return "Here the cards from DB";
	}
}
