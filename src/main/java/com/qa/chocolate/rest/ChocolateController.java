package com.qa.chocolate.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.chocolate.domain.Chocolate;

@RestController
public class ChocolateController {

	private List<Chocolate> choco = new ArrayList<>();
	
	//CRUD
	//Create - POST
	@PostMapping("/createChoco")
	public void createChocolate(@RequestBody Chocolate c) {
		this.choco.add(c);
	}
	
	//Read - GET
	@GetMapping("/getChoco")
	public List<Chocolate> getChocolate() {
		return this.choco;
	}
	
	//Update - PUT /PATCH
	
	//Delete - DELETE
	@DeleteMapping
	public void deleteChocolate(Chocolate c) {
		this.choco.remove(c);
	}
	
	
}
