package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.cruddemo.entity.Pokemon;
import com.luv2code.springboot.cruddemo.service.PokemonService;

@Controller
@RequestMapping("/mvc")
public class PokemonMvcController {

	// need to inject our customer service
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/pokemons")
	public String listPokemon(Model theModel) {
		
		// get customers from the service
		List<Pokemon> losPokemons = pokemonService.findAll();
				
		// add the customers to the model
		theModel.addAttribute("pokemons", losPokemons);
		
		return "list-pokemons";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Pokemon elPokemon = new Pokemon();
		
		theModel.addAttribute("pokemon", elPokemon);
		
		return "pokemon-form";
	}
	
	@PostMapping("/savePokemon")
	public String saveCustomer(@ModelAttribute("pokemon") Pokemon elPokemon) {
		
		// save the customer using our service
		pokemonService.save(elPokemon);	
		
		return "redirect:/mvc/pokemons";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pokemonId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Pokemon elPokemon = pokemonService.findById(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("pokemon", elPokemon);
		
		// send over to our form		
		return "pokemon-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("pokemonId") int theId) {
		
		// delete the customer
		pokemonService.deleteById(theId);
		
		return "redirect:/mvc/pokemons";
	}

}










