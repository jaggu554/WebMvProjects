	package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.ProductEntity;
import com.example.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;
	
	
	@GetMapping("/")
	public String getLoadForm(Model model) {
		
		model.addAttribute("prod", new ProductEntity());
		return "index";
	}
	
	@GetMapping("/edit")
	public String editForm(Model model,@RequestParam("pid") Integer pid) {
		
		Optional<ProductEntity> data =repo.findById(pid);
		model.addAttribute("prod", data);
		
		return "index";
	}
	
	
	
	@PostMapping("/product")
	public String saveData(@Validated @ModelAttribute("prod") ProductEntity p,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			System.out.println(p);
			return "index";
		}
		p=repo.save(p);
		if(p.getPid()!=null) {
			model.addAttribute("msg", "Product saved...");
		}
		return "index";
	}
	
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<ProductEntity> list=repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}
	
	@GetMapping("/delete")
	public String deleteData(@RequestParam("pid") Integer pid,Model model) {
		repo.deleteById(pid);
		model.addAttribute("msg", "Product deleted");
		List<ProductEntity> list=repo.findAll();
		model.addAttribute("products", list);
		return "data";
	}
}
