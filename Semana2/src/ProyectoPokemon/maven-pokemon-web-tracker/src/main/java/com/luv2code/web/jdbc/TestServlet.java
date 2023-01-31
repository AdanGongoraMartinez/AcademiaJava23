package com.luv2code.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Definir el  datasource/connection pool para rescatar la inyección
	@Resource(name="jdbc/web_pokemon_tracker")
	private DataSource dataSource;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Paso 1:  preparar el printwriter
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		
		// Paso 2:  crear una conección a la base de datos
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = dataSource.getConnection();
			
			// Paso 3:  Crear una consulta SQL
			String sql = "select * from Pokemon";
			myStmt = myConn.createStatement();
			
			// Paso 4:  Ejecutar la consulta SQL
			myRs = myStmt.executeQuery(sql);
			
			// Paso 5:  Procesar la serie de resultados
			while (myRs.next()) {
				String tipo2 = myRs.getString("tipo2");
				out.println(tipo2);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}







