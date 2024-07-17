package it.spring.Pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.spring.Pizzeria.Repository.PizzaRepository;
import it.spring.Pizzeria.model.Menu;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



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
	
	   
		@GetMapping("/show/{id}")
		public String show(@PathVariable("id") Integer menuid, Model model) {
			
			model.addAttribute("menu", repository.findById(menuid).get());
			
			return "/menu/show";
		}
		
		@GetMapping("/edit/{id}")
		public String edit(@PathVariable("id") Integer menuid, Model model) {
			
			model.addAttribute("menu", repository.findById(menuid).get());
			
			return "/menu/edit";
		}
		
		@PostMapping("/edit/{id}")
		public String update(@Valid @ModelAttribute("menu") Menu pizzaForm, BindingResult bindingResult, Model model ){
			
			if(bindingResult.hasErrors()) {
				return "/menu/edit";
			}
			
			repository.save(pizzaForm);
			
			return "redirect:/menu";
		}
		
		@PostMapping("/delete/{id}")
		public String delete (@PathVariable("id") Integer id) {
			repository.deleteById(id);
			return "redirect:/menu";
		}
}
	



