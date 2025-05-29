<%--
  Created by IntelliJ IDEA.
  User: ALEXIS XAVIER
  Date: 29/5/2025
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.alexis.superproyecto2.models.Categoria" %>
<%
    Categoria categoria = (Categoria) request.getAttribute("categorias");
    if (categoria == null) {
        categoria = new Categoria(); // categoría vacía para creación
    }
%>
<%-- Declaramos el tipo de contenido de la página y codificación --%>
<html>
<head>
    <%-- El título de la página cambia según si estamos editando o creando una categoría --%>
    <title><%= (categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0) ? "Editar Categoría" : "Nueva Categoría" %></title>
</head>
<body>

<%-- Muestra el encabezado dinámicamente según si estamos creando o editando una categoría --%>
<h1><%= (categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0) ? "Editar Categoría" : "Nueva Categoría" %></h1>

<%-- Formulario que envía los datos al controlador CategoriaFormControlador (POST) --%>
<form action="<%= request.getContextPath() %>/categoria/form" method="post">

    <%-- Campo para el nombre de la categoría, prellenado si ya existe --%>
    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" value="<%= categoria.getNombre() != null ? categoria.getNombre() : "" %>" required />
    <br/><br/>

    <%-- Campo para la descripción de la categoría, también prellenado si existe --%>
    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion" required><%= categoria.getDescripcion() != null ? categoria.getDescripcion() : "" %></textarea>
    <br/><br/>

    <%-- Botón para guardar y un enlace para cancelar (regresa al listado) --%>
    <button type="submit">Guardar</button>
    <a href="/categoria">Cancelar</a>
</form>
</body>
</html>
