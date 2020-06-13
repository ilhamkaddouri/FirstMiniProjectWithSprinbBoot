package com.example.SpringBootProject.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBootProject.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit,Long>{
	public Page<Produit> findByDesignationContains(String mc,Pageable pageable);
	@Query("select p from Produit p where p.designation like :x and p.prix>:y")
	public Page<Produit> chercher(@Param("x")String m,@Param("y")double price,Pageable pageable);
}
