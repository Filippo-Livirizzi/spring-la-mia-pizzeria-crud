package it.spring.Pizzeria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.spring.Pizzeria.model.Menu;

public interface PizzaRepository extends JpaRepository <Menu, Integer> {
	


}
