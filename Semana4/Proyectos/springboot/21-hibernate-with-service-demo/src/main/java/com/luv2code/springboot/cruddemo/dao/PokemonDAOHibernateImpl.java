package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Pokemon;

@Repository
public class PokemonDAOHibernateImpl implements PokemonDAO {

	// define field for entitymanager	
	private EntityManager entityManager;
		
	// set up constructor injection
	@Autowired
	public PokemonDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Pokemon> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<Pokemon> theQuery =
				currentSession.createQuery("from Pokemon", Pokemon.class);
		
		// execute query and get result list
		List<Pokemon> pokemons = theQuery.getResultList();
		
		// return the results		
		return pokemons;
	}


	@Override
	public Pokemon findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Pokemon elPokemon =
				currentSession.get(Pokemon.class, theId);
		
		// return the employee
		return elPokemon;
	}


	@Override
	public void save(Pokemon elPokemon) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save employee
		currentSession.saveOrUpdate(elPokemon);
	}


	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Pokemon where id=:pokemonId");
		theQuery.setParameter("pokemonId", theId);
		
		theQuery.executeUpdate();
	}

}







