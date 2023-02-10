package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Pokemon;
import com.luv2code.springdemo.service.PokemonService;

@RestController
@RequestMapping("/api")
public class PokemonRestController {

	// autowire the CustomerService
	@Autowired
	private PokemonService pokemonService;
	
	// add mapping for GET /customers
	@GetMapping("/pokemons")
	public List<Pokemon> getPokemons() {
		
		return pokemonService.getPokemons();
		
	}
	
	// add mapping for GET /customers/{customerId}
	
	@GetMapping("/pokemons/{pokemonId}")
	public Pokemon getPokemon(@PathVariable int customerId) {
		
		Pokemon elPokemon = pokemonService.getPokemon(customerId);
		
		if (elPokemon == null) {
			throw new PokemonNotFoundException("Pokemon id not found - " + customerId);
		}
		
		return elPokemon;
	}
	
	// add mapping for POST /customers  - add new customer
	
	@PostMapping("/pokemons")
	public Pokemon addPokemon(@RequestBody Pokemon elPokemon) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		elPokemon.setId(0);
		
		pokemonService.savePokemon(elPokemon);
		
		return elPokemon;
	}
	
	// add mapping for PUT /customers - update existing customer
	
	@PutMapping("/pokemons")
	public Pokemon updateCustomer(@RequestBody Pokemon elPokemon) {
		
		pokemonService.savePokemon(elPokemon);
		
		return elPokemon;
		
	}
	
	// add mapping for DELETE /customers/{customerId} - delete customer
	
	@DeleteMapping("/pokemons/{pokemonId}")
	public String deletePokemon(@PathVariable int pokemonId) {
		
		Pokemon tempPokemon = pokemonService.getPokemon(pokemonId);
		
		// throw exception if null
		
		if (tempPokemon == null) {
			throw new PokemonNotFoundException("Pokemon id not found - " + pokemonId);
		}
				
		pokemonService.deletePokemon(pokemonId);
		
		return "Pokemon del id - " + pokemonId + " borrado";
	}
	
}


















