package com.example.SpringBootProject.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=5,max=15,message="name incorect")
	private String designation;
	@NotNull
	@Size(min=5,max=15)
	private double quantite;
	@NotNull
	@Size(min=5,max=15)
	private double prix;
}
