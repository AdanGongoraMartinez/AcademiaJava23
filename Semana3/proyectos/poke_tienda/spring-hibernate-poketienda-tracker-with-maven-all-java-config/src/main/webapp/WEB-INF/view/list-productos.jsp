<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title></title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Tienda de objetos Pokemon</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar Producto"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Cantidad</th>
					<th>Precio</th>
					<th>Acción</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProductos" items="${productos}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/producto/showFormForUpdate">
						<c:param name="productoId" value="${tempProductos.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/producto/delete">
						<c:param name="productoId" value="${tempProductos.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempProductos.nombre} </td>
						<td> ${tempProductos.cantidad} </td>
						<td> ${tempProductos.precio} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Está seguro de querer borrar el producto?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









