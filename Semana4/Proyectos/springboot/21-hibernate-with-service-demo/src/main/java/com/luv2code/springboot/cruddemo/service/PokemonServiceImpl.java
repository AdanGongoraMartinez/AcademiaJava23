package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.PokemonDAO;
import com.luv2code.springboot.cruddemo.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	private PokemonDAO pokemonDAO;
	
	@Autowired
	public PokemonServiceImpl(PokemonDAO elPokemonDAO) {
		pokemonDAO = elPokemonDAO;
	}
	
	@Override
	@Transactional
	public List<Pokemon> findAll() {
		return pokemonDAO.findAll();
	}

	@Override
	@Transactional
	public Pokemon findById(int theId) {
		return pokemonDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Pokemon elPokemon) {
		pokemonDAO.save(elPokemon);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		pokemonDAO.deleteById(theId);
	}

}






