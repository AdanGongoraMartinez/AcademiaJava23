package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Pokemon;

public interface PokemonService {

	public List<Pokemon> getPokemons();

	public void savePokemon(Pokemon theCustomer);

	public Pokemon getPokemon(int theId);

	public void deletePokemon(int theId);
	
}
