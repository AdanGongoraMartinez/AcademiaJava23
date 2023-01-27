package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PokemonDbUtil {

	private DataSource dataSource;

	public PokemonDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public List<Pokemon> getPokemons() throws Exception {
		
		List<Pokemon> pokemons = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from Pokemon order by Nombre";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nombre = myRs.getString("Nombre");
				String tipo1 = myRs.getString("Tipo1");
				String tipo2 = myRs.getString("Tipo2");
				
				// create new student object
				Pokemon tempPokemon = new Pokemon(id, nombre, tipo1, tipo2);
				
				// add it to the list of students
				pokemons.add(tempPokemon);				
			}
			
			return pokemons;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void addPokemon (Pokemon thePokemon) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into Pokemon "
					   + "(Nombre, Tipo1, Tipo2) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, thePokemon.getNombre());
			myStmt.setString(2, thePokemon.getTipo1());
			myStmt.setString(3, thePokemon.getTipo2());
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public Pokemon getPokemon(String thePokemonId) throws Exception {

		Pokemon thePokemon = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int pokemonId;
		
		try {
			// convert student id to int
			pokemonId = Integer.parseInt(thePokemonId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from Pokemon where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pokemonId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("Nombre");
				String tipo1 = myRs.getString("Tipo1");
				String tipo2 = myRs.getString("Tipo2");
				
				// use the studentId during construction
				thePokemon = new Pokemon(pokemonId, nombre, tipo1, tipo2);
			}
			else {
				throw new Exception("Could not find pokemon id: " + pokemonId);
			}				
			
			return thePokemon;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void updatePokemon(Pokemon thePokemon) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update Pokemon "
						+ "set Nombre=?, Tipo1=?, Tipo2=? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, thePokemon.getNombre());
			myStmt.setString(2, thePokemon.getTipo1());
			myStmt.setString(3, thePokemon.getTipo2());
			myStmt.setInt(4, thePokemon.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deletePokemon(String thePokemonId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int pokemonId = Integer.parseInt(thePokemonId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from Pokemon where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, pokemonId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}















