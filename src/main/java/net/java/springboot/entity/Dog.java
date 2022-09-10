package net.java.springboot.entity;

import javax.persistence.*;
import lombok.*;


@Table(name="tbl_dog")
@Entity
@Data
public class Dog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String image;

	
}
