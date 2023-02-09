package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Pokemon;

@Repository
public class PokemonDAOImpl implements PokemonDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Pokemon> getPokemon() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Pokemon> theQuery = 
				currentSession.createQuery("from Pokemon order by nombre",
											Pokemon.class);
		
		// execute query and get result list
		List<Pokemon> pokemons = theQuery.getResultList();
				
		// return the results		
		return pokemons;
	}

	@Override
	public void savePokemon(Pokemon elPokemon) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(elPokemon);
		
	}

	@Override
	public Pokemon getPokemon(int elId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Pokemon elPokemon = currentSession.get(Pokemon.class, elId);
		
		return elPokemon;
	}

	@Override
	public void deletePokemon(int elId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", elId);
		
		theQuery.executeUpdate();		
	}

}











