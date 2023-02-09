package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Pokemon;

public interface PokemonDAO {

	public List<Pokemon> getPokemon();

	public void savePokemon(Pokemon elPokemon);

	public Pokemon getPokemon(int elId);

	public void deletePokemon(int elId);
	
}
