package net.java.springboot.controller;

import net.java.springboot.service.DogExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/external/dogs")
public class DogExternalController {

    @Autowired
    private DogExternalService service;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        var result = service.getAllDogs();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{breed}/images")
    public ResponseEntity<?> getImagesByBreed(@PathVariable String breed) {
        var result = service.getImagesByBreed(breed);
        return ResponseEntity.ok(result);
    }
}
