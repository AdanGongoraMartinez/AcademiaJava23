package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.PokemonDAO;
import com.luv2code.springdemo.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	// need to inject customer dao
	@Autowired
	private PokemonDAO pokemonDAO;
	
	@Override
	@Transactional
	public List<Pokemon> getPokemons() {
		return pokemonDAO.getPokemon();
	}

	@Override
	@Transactional
	public void savePokemon(Pokemon elPokemon) {

		pokemonDAO.savePokemon(elPokemon);
	}

	@Override
	@Transactional
	public Pokemon getPokemon(int elId) {
		
		return pokemonDAO.getPokemon(elId);
	}

	@Override
	@Transactional
	public void deletePokemon(int elId) {
		
		pokemonDAO.deletePokemon(elId);
	}
}





