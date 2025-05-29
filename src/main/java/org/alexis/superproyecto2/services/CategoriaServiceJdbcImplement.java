package org.alexis.superproyecto2.services;

import org.alexis.superproyecto2.models.Categoria;
import org.alexis.superproyecto2.repositorio.CategoriaRepositorioJdbcImplement;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CategoriaServiceJdbcImplement implements CategoriaService {
    //creamos una variable de tipo categoria repository jdbc implement
    //creamos una variable de tipo connection
    private CategoriaRepositorioJdbcImplement repositorioJdbcImplement;
    public CategoriaServiceJdbcImplement(Connection conn){
        this.repositorioJdbcImplement = new CategoriaRepositorioJdbcImplement(conn);
    }

    @Override
    public List<Categoria> Listar() {
        try {
            return repositorioJdbcImplement.listar();
        }catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),throwables.getCause());
        }
    }

    @Override
    public Optional<Categoria> porId(Long id) {
        try {
            return Optional.ofNullable(repositorioJdbcImplement.PorId(id));
        } catch (SQLException throwables) {
            throw new ServiceJdbcException(throwables.getMessage(),throwables.getCause());

        }
    }
}