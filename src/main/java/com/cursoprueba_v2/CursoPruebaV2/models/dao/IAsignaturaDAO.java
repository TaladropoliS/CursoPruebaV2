package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AsignaturaDTO;

import java.util.List;

public interface IAsignaturaDAO{

    List<AsignaturaDTO> listarTodos();

    void guardar(AsignaturaDTO asignatura);

    AsignaturaDTO buscarPorId(Integer idAsi);

    void eliminar(Integer idAsi);
}
