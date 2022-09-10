package net.java.springboot.controller;

import java.util.*;

import net.java.springboot.service.DogService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import net.java.springboot.entity.*;

@RestController
@RequestMapping("/dogs")
public class DogController {
	
	@Autowired
	DogService dogService;
	
	@PostMapping
	public ResponseEntity<Dog> save(@RequestBody Dog dog) {
		var result = dogService.save(dog);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<Dog>> findAll() {
		var result = dogService.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dog> findById(@PathVariable("id") Long id) {
		var result = dogService.findById(id);
		return result.isPresent() ? ResponseEntity.ok(result.get()) : (ResponseEntity<Dog>) ResponseEntity.status(HttpStatus.NOT_FOUND);
	}
	
	
	@PutMapping
	public ResponseEntity<Dog> updated(@RequestBody Dog dog) {
		var result = dogService.update(dog);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteDog(@PathVariable("id") Long id){
		try {
			Optional<Dog> dog = dogService.findById(id);
			if(dog.isPresent()) {
				dogService.delete(dog.get());
			}
			
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
