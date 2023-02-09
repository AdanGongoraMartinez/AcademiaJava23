package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Pokemon;

public interface PokemonService {

	public List<Pokemon> findAll();
	
	public Pokemon findById(int theId);
	
	public void save(Pokemon elPokemon);
	
	public void deleteById(int theId);
	
}
