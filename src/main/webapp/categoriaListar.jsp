<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, org.alexis.superproyecto2.models.*" %>

<%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
    Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <title>Listado de Categorías</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/estilos.css" />
</head>
<body>

<h1>Listado de Categorías</h1>

<p>
    Usuario: <strong><%= username.isPresent() ? username.get() : "Invitado" %></strong>
</p>

<table class="tabla-categoriaListar">
    <thead>
    <tr>
        <th>Id Categoría</th>
        <th>Nombre</th>
        <th>Descripción</th>
        <th>Condición</th>
        <th>Acciones</th>
        <th></th> <!-- Para segunda acción -->
    </tr>
    </thead>
    <tbody>
    <% for (Categoria cat : categorias) { %>
    <tr>
        <td><%= cat.getIdCategoria() %></td>
        <td><%= cat.getNombre() %></td>
        <td><%= cat.getDescripcion() %></td>
        <td><%= cat.getCondicion() %></td>
        <td><a href="#">Editar</a></td>
        <td><a href="#">Activar o Desactivar</a></td>
    </tr>
    <% } %>
    </tbody>
</table>

</body>
</html>