package com.deyvidsalvatore.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
	
	@GetMapping("/notices")
	public String getNotices() {
		return "Here the notices from DB";
	}

}
