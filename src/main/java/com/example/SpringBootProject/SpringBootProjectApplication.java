package com.example.SpringBootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.SpringBootProject.dao.ProduitRepository;
import com.example.SpringBootProject.entities.Produit;

@SpringBootApplication
public class SpringBootProjectApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("***********************");
		produitRepository.save(new Produit(null,"ordi hp ",54,5400));
		produitRepository.save(new Produit(null,"imp ",60,5640));
		produitRepository.save(new Produit(null,"smart hp ",12,3250));
		Page<Produit> produits = produitRepository.findByDesignationContains("h",PageRequest.of(0,2));
		System.out.println(produits.getTotalElements());
		System.out.println(produits.getSize());
		produits.getContent().forEach(p->{
			System.out.println(p.toString());
		});
		
		/*System.out.println("------------------------------------");
		Page<Produit> prods = produitRepository.chercher("%h%", 4000, PageRequest.of(0,2));
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getSize());
		prods.getContent().forEach(p->{
			System.out.println(p.toString());
		});*/
		
	}

}
