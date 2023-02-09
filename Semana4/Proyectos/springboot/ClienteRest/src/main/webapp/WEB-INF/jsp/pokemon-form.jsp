<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Pokemon</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>SpringBoot Pokemon</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Pokemon</h3>
	
		<form:form action="savePokemon" modelAttribute="pokemon" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Tipo 1:</label></td>
						<td><form:input path="tipo1" /></td>
					</tr>

					<tr>
						<td><label>Tipo 2:</label></td>
						<td><form:input path="tipo2" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/mvc/pokemons">Regresar</a>
		</p>
	
	</div>

</body>

</html>










