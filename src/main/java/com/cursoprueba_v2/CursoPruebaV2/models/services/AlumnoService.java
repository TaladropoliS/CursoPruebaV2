package com.cursoprueba_v2.CursoPruebaV2.models.services;

import com.cursoprueba_v2.CursoPruebaV2.models.dao.IAlumnoDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dao.IAsignaturaDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dao.ICarreraDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dao.IEvaluacionDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.EvaluacionDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoDAO alumnoDAO;

    @Autowired
    private IEvaluacionDAO evaluacionDAO;

//    @Autowired
//    private IAsignaturaDAO asignaturaDAO;
//
//    @Autowired
//    private ICarreraDAO carreraDAO;

    @Override
    public List<AlumnoDTO> listarAlumnosDTO() {
        List<AlumnoDTO> alumnos = alumnoDAO.listarTodos();
        alumnos.forEach(this::calcularPromConSitFinal);
        return alumnos;
    }


    @Override
    @Transactional
    public void guardarAlumno(AlumnoDTO alumno) {
        alumnoDAO.guardar(alumno);
    }


    @Override
    @Transactional
    public void eliminarAlumno(String runAlu) {
        alumnoDAO.eliminar(runAlu);
    }

    @Override
    public AlumnoDTO buscarAlumnoPorId(String runAlu) {
        return alumnoDAO.buscarPorId(runAlu);
    }

    private void calcularPromConSitFinal(AlumnoDTO alumno) {
        List<EvaluacionDTO> evaluaciones = evaluacionDAO.findByAlumno(alumno);
        double promedio = 0;
        for (EvaluacionDTO evaluacion : evaluaciones) {
            promedio += evaluacion.getNotEva();
        }
        promedio = Math.round((promedio / evaluaciones.size()) * 10.0) / 10.0;
        alumno.setPromedio(promedio);
        if (promedio >= 4.0) {
            alumno.setSituacionFinal("Aprobado");
        } else {
            alumno.setSituacionFinal("Reprobado");
        }
    }

    public void listarEvaluacionesPorAlumno(AlumnoDTO alumno) {
        List<EvaluacionDTO> evaluaciones = evaluacionDAO.findByAlumno(alumno);
        alumno.getEvaluaciones().addAll(evaluaciones);
    }
}
