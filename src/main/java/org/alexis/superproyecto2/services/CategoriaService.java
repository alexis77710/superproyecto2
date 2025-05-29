package org.alexis.superproyecto2.services;

import org.alexis.superproyecto2.models.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> Listar();
    Optional<Categoria> porId(Long id);
    //implementar metodos guardar,activar y desactivar
}