package it.spring.Pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import it.spring.Pizzeria.Repository.PizzaRepository;
import it.spring.Pizzeria.model.Menu;

import org.springframework.ui.Model;



@Controller
@RequestMapping ("/menu")
public class PizzaControl {
	
	@Autowired
	private PizzaRepository repository;
	
	@GetMapping
	public String index (Model model) {

		List<Menu> pizza = new ArrayList<>();
				
		pizza = repository.findAll();
		
		model.addAttribute("menu", pizza);
		
		return "/menu/index";
	}
	
	   @GetMapping("/dettaglio/{id}")
	   public String dettaglio (@PathVariable ("id") Integer id, Model model) {
		   
		   model.addAttribute("dettaglio", repository.getReferenceById(id));
		   
		   return "/menu/dettaglio";
	   }
	   

	   
	   

}
	



