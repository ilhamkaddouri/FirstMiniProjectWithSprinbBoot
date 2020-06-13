package com.example.SpringBootProject.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringBootProject.dao.ProduitRepository;
import com.example.SpringBootProject.entities.Produit;
@Controller
public class ProduitController {
	@Autowired
	private ProduitRepository produitRepository;
	@GetMapping(path="/index")
	public String index() {
		return "index";
	}
	@GetMapping(path="/products")
	public String products(Model model,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="motCle",defaultValue="")String motCle) {
		Page<Produit> produits = produitRepository.findByDesignationContains(motCle,PageRequest.of(page, size));
		model.addAttribute("pageproduits",produits);
		model.addAttribute("pages",new int[produits.getTotalPages()]);
		model.addAttribute("currentpage",page);
		model.addAttribute("size",size);
		model.addAttribute("motCle",motCle);
		return "products";
	}
	@GetMapping(path="/deleteProduits")
	public String delete(Long id,String motCle,String page,String size) {
		produitRepository.deleteById(id);
		return "redirect:/products?page="+page+"&size="+size+"&motCle="+motCle;
	}
	@GetMapping(path="/formProduit")
	public String formProduit(Model model) {
		model.addAttribute("produit",new Produit());
		return "formProduit";
	}
	@PostMapping(path="/saveProduit")
	public String saveProduit(@Valid Produit produit,BindingResult bindingresult) {
		if(bindingresult.hasErrors()) return "formProduit";
		produitRepository.save(produit);
		return "formProduit";
	}
}
