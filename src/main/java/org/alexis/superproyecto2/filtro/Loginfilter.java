package org.alexis.superproyecto2.filtro;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.alexis.superproyecto2.services.LoginService;
import org.alexis.superproyecto2.services.LoginServiceSessionImplement;
import org.alexis.superproyecto2.services.ServiceJdbcException;
import org.alexis.superproyecto2.util.Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;


@WebFilter({"/productos","/agregar-carro"})
public class Loginfilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoginService service = new LoginServiceSessionImplement();
        Optional<String> username = service.getUserName((HttpServletRequest) servletRequest );
        // realizo una condicional para ver si esta presente el nombre del usuario
        if (username.isPresent()) {
            filterChain.doFilter(servletRequest, servletResponse);

        }else{
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no estas autorizado para ingresar a esta pagina");

        }
    }
}