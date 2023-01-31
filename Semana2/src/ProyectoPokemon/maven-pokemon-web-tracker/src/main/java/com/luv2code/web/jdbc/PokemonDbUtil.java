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
			// Obtener una conexión
			myConn = dataSource.getConnection();
			
			// crear una sentencia sql
			String sql = "select * from Pokemon order by Nombre";
			
			myStmt = myConn.createStatement();
			
			// ejecutar el query
			myRs = myStmt.executeQuery(sql);
			
			// Procesar la serie de resultados
			while (myRs.next()) {
				
				// recibir los datos de la serie de resultados
				int id = myRs.getInt("id");
				String nombre = myRs.getString("Nombre");
				String tipo1 = myRs.getString("Tipo1");
				String tipo2 = myRs.getString("Tipo2");
				
				// crear un nuevo objeto pokemon
				Pokemon tempPokemon = new Pokemon(id, nombre, tipo1, tipo2);
				
				// añadirlo a la lista de pokemon
				pokemons.add(tempPokemon);				
			}
			
			return pokemons;		
		}
		finally {
			// cerrar los objetos JDBC
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
				myConn.close();   // No se cierra como tal, solo se pone de nuevo en la connection pool
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
			// obtener una conexión con la DB
			myConn = dataSource.getConnection();
			
			// crear un sql para insertar
			String sql = "insert into Pokemon "
					   + "(Nombre, Tipo1, Tipo2) "
					   + "values (?, ?, ?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			// Colocar los valores param para el pokemon
			myStmt.setString(1, thePokemon.getNombre());
			myStmt.setString(2, thePokemon.getTipo1());
			myStmt.setString(3, thePokemon.getTipo2());
			
			// ejecutar el sql para insertar
			myStmt.execute();
		}
		finally {
			// cerrar los objetos JDBC
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
			// convertir la id del estudiante en un entero
			pokemonId = Integer.parseInt(thePokemonId);
			
			// obtener una conexión a la DB
			myConn = dataSource.getConnection();
			
			// crear un sql para seleción al pokemon
			String sql = "select * from Pokemon where id=?";
			
			// crear un prepared
			myStmt = myConn.prepareStatement(sql);
			
			// colocar params
			myStmt.setInt(1, pokemonId);
			
			// ejecutar la sentencia sql
			myRs = myStmt.executeQuery();
			
			// recuperar datos del conjunto de resultados
			if (myRs.next()) {
				String nombre = myRs.getString("Nombre");
				String tipo1 = myRs.getString("Tipo1");
				String tipo2 = myRs.getString("Tipo2");
				
				// usar la Id del pokemon durante la construcción
				thePokemon = new Pokemon(pokemonId, nombre, tipo1, tipo2);
			}
			else {
				throw new Exception("No pudimos hayar la id del pokemon: " + pokemonId);
			}				
			
			return thePokemon;
		}
		finally {
			// cerrar los objetos JDBC
			close(myConn, myStmt, myRs);
		}
	}

	public void updatePokemon(Pokemon thePokemon) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// crear una conexión
			myConn = dataSource.getConnection();
			
			// crear una sentencia SQL para actualizar
			String sql = "update Pokemon "
						+ "set Nombre=?, Tipo1=?, Tipo2=? "
						+ "where id=?";
			
			// preparar la sentencia SQL
			myStmt = myConn.prepareStatement(sql);
			
			// colocar params
			myStmt.setString(1, thePokemon.getNombre());
			myStmt.setString(2, thePokemon.getTipo1());
			myStmt.setString(3, thePokemon.getTipo2());
			myStmt.setInt(4, thePokemon.getId());
			
			// ejecutar SQL
			myStmt.execute();
		}
		finally {
			// cerrar los JDBC
			close(myConn, myStmt, null);
		}
	}

	public void deletePokemon(String thePokemonId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convertir la id del pokemon en entero
			int pokemonId = Integer.parseInt(thePokemonId);
			
			// conectarse al datasource
			myConn = dataSource.getConnection();
			
			// crear un SQL para borrar
			String sql = "delete from Pokemon where id=?";
			
			// preparar SQL
			myStmt = myConn.prepareStatement(sql);
			
			// colocar params
			myStmt.setInt(1, pokemonId);
			
			// ejecutar el SQL
			myStmt.execute();
		}
		finally {
			// cerrar los JDBC
			close(myConn, myStmt, null);
		}	
	}
}















