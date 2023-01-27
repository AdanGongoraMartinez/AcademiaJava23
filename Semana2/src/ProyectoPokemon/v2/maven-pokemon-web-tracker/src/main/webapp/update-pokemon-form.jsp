<!DOCTYPE html>
<html>

<head>
	<title>Update Pokemon</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-pokemon-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Actualizar Pokemon</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Cambiar Pokemon</h3>
		
		<form action="PokemonControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="pokemonId" value="${THE_POKEMON.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><input type="text" name="Nombre" 
								   value="${THE_POKEMON.nombre}" /></td>
					</tr>

					<tr>
						<td><label>Tipo 1:</label></td>
						<td><input type="text" name="Tipo1" 
								   value="${THE_POKEMON.tipo1}" /></td>
					</tr>

					<tr>
						<td><label>Tipo 2:</label></td>
						<td><input type="text" name="Tipo2" 
								   value="${THE_POKEMON.tipo2}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="PokemonControllerServlet">Regresar</a>
		</p>
	</div>
</body>

</html>











