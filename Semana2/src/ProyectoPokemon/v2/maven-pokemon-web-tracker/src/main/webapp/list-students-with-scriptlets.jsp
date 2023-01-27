<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Pokémon Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the students from the request object (sent by servlet)
	List<Pokemon> thePokemons = 
			(List<Pokemon>) request.getAttribute("POKEMON_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>Nombre</th>
					<th>Tipo 1</th>
					<th>Tipo 2</th>
				</tr>
				
				<%
								for (Pokemon tempPokemon : thePokemons) {
								%>
				
					<tr>
						<td> <%= tempPokemon.getNombre() %> </td>
						<td> <%= tempPokemon.getTipo1() %> </td>
						<td> <%= tempPokemon.getTipo2() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








