package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/PokemonControllerServlet")
public class PokemonControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PokemonDbUtil pokemonDbUtil;
	
	@Resource(name="jdbc/web_pokemon_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// creando un pokemon db util pasando un datasource
		try {
			pokemonDbUtil = new PokemonDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// Leer el comando
			String theCommand = request.getParameter("command");
			
			// Si el comando no apunta a un objeto, hacemos que apunte a List
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// Se aplica la accion correspondiente a la referencia del comando
			switch (theCommand) {
			
			case "LIST":
				listPokemons(request, response);
				break;
				
			case "ADD":
				addPokemon(request, response);
				break;
				
			case "LOAD":
				loadPokemon(request, response);
				break;
				
			case "UPDATE":
				updatePokemon(request, response);
				break;
			
			case "DELETE":
				deletePokemon(request, response);
				break;
				
			default:
				listPokemons(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deletePokemon(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// Lee la id del pokemon de los datos del formulario
		String thePokemonId = request.getParameter("pokemonId");
		
		// Borra al pokemon de la DB
		pokemonDbUtil.deletePokemon(thePokemonId);
		
		// Regresa a la lista de pokemon
		listPokemons(request, response);
	}

	private void updatePokemon(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// Lee la información del pokemon
		int id = Integer.parseInt(request.getParameter("pokemonId"));
		String nombre = request.getParameter("Nombre");
		String tipo1 = request.getParameter("Tipo1");
		String tipo2 = request.getParameter("Tipo2");	
		
		// crea un pokemon
		Pokemon thePokemon = new Pokemon(id, nombre, tipo1, tipo2);
		
		// hace una actualización en la DB
		pokemonDbUtil.updatePokemon(thePokemon);
		
		// Regresa a la lista de pokemon
		listPokemons(request, response);
		
	}

	private void loadPokemon(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// Lee la id del pokemon
		String thePokemonId = request.getParameter("pokemonId");
		
		// obtiene al estudiante de la base de datos (DB util)
		Pokemon thePokemon = pokemonDbUtil.getPokemon(thePokemonId);
		
		// Coloca al pokemon en el atributo que se pide
		request.setAttribute("THE_POKEMON", thePokemon);
		
		// Se envia al jsp: update-pokemon-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-pokemon-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addPokemon(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Se lle la información del pokemon
		String nombre = request.getParameter("Nombre");
		String tipo1 = request.getParameter("Tipo1");
		String tipo2 = request.getParameter("Tipo2");		
		
		// crea un nuevo objeto pokemon
		Pokemon thePokemon = new Pokemon(nombre, tipo1, tipo2);
		
		// añade al pokemon a la base de datos
		pokemonDbUtil.addPokemon(thePokemon);
				
		// Regresa a la lista de pokemon
		listPokemons(request, response);
	}

	private void listPokemons(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// obtener pokemon de db util
		List<Pokemon> pokemons = pokemonDbUtil.getPokemons();
		
		// añadir pokemon al request
		request.setAttribute("POKEMON_LIST", pokemons);
				
		// enviar al JSP (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-pokemons.jsp");
		dispatcher.forward(request, response);
	}

}













