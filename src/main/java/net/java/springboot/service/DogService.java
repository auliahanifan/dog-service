package net.java.springboot.service;

import lombok.extern.slf4j.Slf4j;
import net.java.springboot.entity.Dog;
import net.java.springboot.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    public Dog save(Dog entity) {
        return dogRepository.save(entity);
    }

    public List<Dog> findAll() {
        return dogRepository.findAll();
    }

    public Optional<Dog> findById(Long id) {
        return dogRepository.findById(id);
    }

    public Dog update(Dog entity) {
        return dogRepository.save(entity);
    }

    public void delete(Dog entity) {
        dogRepository.delete(entity);
    }

}
