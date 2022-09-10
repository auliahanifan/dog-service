package net.java.springboot.service;

import net.java.springboot.entity.Dog;
import net.java.springboot.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DogServiceTest {

    @Mock
    private DogRepository dogRepository;

    @InjectMocks
    private DogService dogService;

    @Test
    void saveTest() {
        Dog dog = new Dog(1L, "Dog", "Dog");
        when(dogRepository.findAll()).thenReturn(List.of(dog));

        var result = dogService.findAll();

        assertEquals(List.of(dog), result);
    }

}