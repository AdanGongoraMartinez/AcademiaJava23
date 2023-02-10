<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Pokemon</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>SpringBoot Pokemon</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Pokemon"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Tipo 1</th>
					<th>Tipo 2</th>
					<th>Accion</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPokemon" items="${pokemons}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/mvc/showFormForUpdate">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/mvc/delete">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPokemon.nombre} </td>
						<td> ${tempPokemon.tipo1} </td>
						<td> ${tempPokemon.tipo2} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Estas seguro de querer borrar al pokemon?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









