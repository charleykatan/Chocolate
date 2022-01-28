package com.qa.chocolate.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.chocolate.domain.Chocolate;

@RestController
public class ChocolateController {

	private List<Chocolate> choco = new ArrayList<>();
	
	// Response entity -> allows us to configure the status code of the response
	
	//CRUD
	//Create - POST
	//Response to return instead of 200: 201 - created
	@PostMapping("/createChoco")
	public ResponseEntity<Chocolate> createChocolate(@RequestBody Chocolate c) {
		this.choco.add(c);
		Chocolate newChoc = this.choco.get(this.choco.size() - 1);
		return new ResponseEntity<Chocolate>(newChoc, HttpStatus.CREATED);
	}
	
	//Read - GET
	@GetMapping("/getChoco")
	public List<Chocolate> getChocolate() {
		return this.choco;
	}
	
	// Read by ID - GET
	@GetMapping("/getChoco/{id}")
	public Chocolate getChocoId(@PathVariable int id) {
		return this.choco.get(id);
	}
	
	//Update - PUT /PATCH
	@PutMapping("/update/{id}")
	public Chocolate updateChocolate(@PathVariable int id, @RequestBody Chocolate c) {
		this.choco.set(id, c);
		return this.choco.get(id);
	}
	
	@PatchMapping("/updateBrand/{id}")
	public Chocolate replaceBrand(@PathParam("brand") String brand, @PathVariable int id) {
		(this.choco.get(id)).setBrand(brand);
		return this.choco.get(id);
	}
	
	@PatchMapping("/updateName/{id}")
	public Chocolate replaceName(@RequestBody String name, @PathVariable int id) {
		(this.choco.get(id)).setName(name);
		return this.choco.get(id);
	}
	
	//Delete - DELETE
	@DeleteMapping("/deleteChoco/{id}")
	public Chocolate deleteChocolate(@PathVariable int id) {
		return this.choco.remove(id);
	}
	
}
