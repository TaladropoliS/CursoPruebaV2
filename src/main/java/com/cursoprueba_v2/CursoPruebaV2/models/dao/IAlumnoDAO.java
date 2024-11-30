package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;

import java.util.List;

public interface IAlumnoDAO {

    List<AlumnoDTO> listarTodos();

    void guardar(AlumnoDTO alumno);

    AlumnoDTO buscarPorId(String runAlu);

    void eliminar(String runAlu);
}
