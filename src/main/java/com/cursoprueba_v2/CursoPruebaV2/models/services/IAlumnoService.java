package com.cursoprueba_v2.CursoPruebaV2.models.services;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;

import java.util.List;

public interface IAlumnoService {

    List<AlumnoDTO> listarAlumnosDTO();

    AlumnoDTO buscarAlumnoPorId(String runAlu);

    void guardarAlumno(AlumnoDTO alumno);

    void eliminarAlumno(String runAlu);

    void listarEvaluacionesPorAlumno(AlumnoDTO alumno);
}
