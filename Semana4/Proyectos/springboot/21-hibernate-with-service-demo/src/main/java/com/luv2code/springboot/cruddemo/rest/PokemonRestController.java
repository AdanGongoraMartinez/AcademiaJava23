package com.luv2code.springboot.cruddemo.rest;

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

import com.luv2code.springboot.cruddemo.entity.Pokemon;
import com.luv2code.springboot.cruddemo.service.PokemonService;

@RestController
@RequestMapping("/api")
public class PokemonRestController {

	private PokemonService pokemonService;
	
	@Autowired
	public PokemonRestController(PokemonService elPokemonService) {
		pokemonService = elPokemonService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/pokemons")
	public List<Pokemon> findAll() {
		return pokemonService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/pokemons/{pokemonId}")
	public Pokemon getEmployee(@PathVariable int pokemonId) {
		
		Pokemon elPokemon = pokemonService.findById(pokemonId);
		
		if (elPokemon == null) {
			throw new RuntimeException("Pokemon id not found - " + pokemonId);
		}
		
		return elPokemon;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/pokemons")
	public Pokemon addEmployee(@RequestBody Pokemon elPokemon) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		elPokemon.setId(0);
		
		pokemonService.save(elPokemon);
		
		return elPokemon;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/pokemons")
	public Pokemon updateEmployee(@RequestBody Pokemon elPokemon) {
		
		pokemonService.save(elPokemon);
		
		return elPokemon;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/pokemons/{pokemonId}")
	public String deleteEmployee(@PathVariable int pokemonId) {
		
		Pokemon tempEmployee = pokemonService.findById(pokemonId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Pokemon id not found - " + pokemonId);
		}
		
		pokemonService.deleteById(pokemonId);
		
		return "Deleted pokemon id - " + pokemonId;
	}
	
}










