package net.java.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.*;

import net.java.springboot.entity.*;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

}
