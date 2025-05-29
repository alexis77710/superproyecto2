<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="/superproyecto2/estilos.css"> <%-- Asegúrate de que esté en la misma carpeta o ajusta la ruta --%>
</head>
<body>

<div class="login-container">
  <h2>Login de usuario</h2>
  <form action="/superproyecto2/login" method="post">

    <div>
      <label for="username">Nombre de usuario:</label>
      <div>
        <input type="text" name="username" id="username" required>
      </div>
    </div>

    <div>
      <label for="pass">Contraseña:</label>
      <div>
        <input type="password" name="password" id="pass" required>
      </div>
    </div>

    <div>
      <button type="submit">Enviar</button>
    </div>

    <%-- Aquí puedes mostrar mensajes de error si lo deseas --%>
    <% String error = request.getParameter("error");
      if (error != null) { %>
    <div class="error-message">Usuario o contraseña incorrectos</div>
    <% } %>

    <a href="/superproyecto2/register.jsp" class="register-link">¿No tienes cuenta? Regístrate</a>

  </form>
</div>

</body>
</html>