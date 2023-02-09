package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Pokemon;

public interface PokemonDAO {

	public List<Pokemon> findAll();
	
	public Pokemon findById(int theId);
	
	public void save(Pokemon elPokemon);
	
	public void deleteById(int theId);
	
}
