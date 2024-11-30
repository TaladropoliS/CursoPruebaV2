package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.EvaluacionDTO;

import java.util.List;

public interface IEvaluacionDAO {

    List<EvaluacionDTO> listarTodos();

    void guardar(EvaluacionDTO evaluacion);

    EvaluacionDTO buscarPorId(Integer idEva);

    void eliminar(Integer idEva);

    List<EvaluacionDTO> findByAlumno(AlumnoDTO alumno);

}
