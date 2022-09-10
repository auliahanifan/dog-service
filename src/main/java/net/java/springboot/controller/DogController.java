package net.java.springboot.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import net.java.springboot.entity.*;
import net.java.springboot.repository.*;

@RestController
@RequestMapping("/dogs")
public class DogController {
	
	@Autowired
	IDogRepo dogRepo;
	
	@PostMapping
	public ResponseEntity<Dog> save(@RequestBody Dog dog) {
		try {
			return new ResponseEntity<>(dogRepo.save(dog), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Dog>> findAll() {
		try {
			List<Dog> list = dogRepo.findAll();
			if(list.isEmpty()) {
				return new ResponseEntity<List<Dog>>(HttpStatus.NO_CONTENT);
			} 
			
			return new ResponseEntity<List<Dog>>(list,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Dog> findById(@PathVariable("id") Long id) {
		Optional<Dog> dog = dogRepo.findById(id);
		
		if (dog.isPresent()) {
			return new ResponseEntity<Dog>(dog.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Dog>(HttpStatus.NOT_FOUND); 
	}
	
	
	@PutMapping
	public ResponseEntity<Dog> updated(@RequestBody Dog dog) {
		try {
			return new ResponseEntity<>(dogRepo.save(dog), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteDog(@PathVariable("id") Long id){
		try {
			Optional<Dog> dog = dogRepo.findById(id);
			if(dog.isPresent()) {
				dogRepo.delete(dog.get());
			}
			
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
