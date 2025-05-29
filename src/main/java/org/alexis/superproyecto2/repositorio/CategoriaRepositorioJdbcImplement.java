package org.alexis.superproyecto2.repositorio;

import org.alexis.superproyecto2.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioJdbcImplement  implements Repositorio<Categoria>{

    //creamos una variable donde vamos a guardar la conexion
    private Connection conn;
    public CategoriaRepositorioJdbcImplement(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM categoria");
            while (rs.next()) {
                Categoria c = getCategoria(rs);
                categorias.add(c);
            }
        }
        return categorias;
    }




    @Override
    public Categoria PorId(Long id) throws SQLException {
        //Creop un objeto de tipo categoria null
        Categoria categoria = null;
        try(PreparedStatement stmt = conn.prepareStatement(
                "select * from categoria where id = ?")){
            stmt.setLong(1,id);
            try(ResultSet rs = stmt.executeQuery()){
                categoria = getCategoria(rs);

            }

        }
        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        // Declaración de la variable SQL
        String sql;

        // Determina si se trata de una actualización (UPDATE) o una inserción nueva (INSERT)
        boolean esUpdate = categoria.getIdCategoria() != null && categoria.getIdCategoria() > 0;

        if (esUpdate) {
            // Si el ID existe, se actualiza la categoría existente
            sql = "UPDATE categoria SET nombre = ?, descripcion = ? WHERE idCategoria = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, categoria.getNombre());
                stmt.setString(2, categoria.getDescripcion());
                stmt.setLong(3, categoria.getIdCategoria());
                stmt.executeUpdate();
            }
        } else {
            // Si el ID no existe, se inserta una nueva categoría
            // La condición se pone en 1 por defecto (activo)
            sql = "INSERT INTO categoria (nombre, descripcion, condicion) VALUES (?, ?, 1)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, categoria.getNombre());
                stmt.setString(2, categoria.getDescripcion());
                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "UPDATE categoria SET condicion = 0 WHERE idCategoria = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }



    private static Categoria getCategoria(ResultSet rs) throws SQLException {
        Categoria c = new Categoria(); //Creo un nuevo objeto vació de la clase categoría porque lo lleno con lo de abajo
        c.setNombre(rs.getString("nombre")); //Settear el nombre del método getString del javaBeans
        c.setDescripcion(rs.getString("descripcion"));
        c.setCondicion(rs.getInt("condicion"));
        c.setIdCategoria(rs.getLong("idCategoria"));
        return c;
    }
}