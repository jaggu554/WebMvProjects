package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer pid;
	
	@NotBlank(message = "Name is Mandatory")
	@Size(min=3,max=15,message="Name should from 3 to 15 characters")
	public String name;
	@NotNull(message = "price is Mandatory")
	public Double price;
	@NotNull(message="quanity is Mandatory")
	public Integer quantity;
	
}
