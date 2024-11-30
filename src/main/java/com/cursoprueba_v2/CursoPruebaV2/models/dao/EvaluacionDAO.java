package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.EvaluacionDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EvaluacionDAO implements IEvaluacionDAO {

    @Autowired
    private EntityManager em;

    public void guardar(EvaluacionDTO evaluacion) {
        em.persist(evaluacion);
    }

    public EvaluacionDTO buscarPorId(Integer idEva) {
        return em.find(EvaluacionDTO.class, idEva);
    }

    public void eliminar(Integer idEva) {
        EvaluacionDTO evaluacion = buscarPorId(idEva);
        if (evaluacion != null) {
            em.remove(evaluacion);
        }
    }

    public List<EvaluacionDTO> listarTodos() {
        String query = "FROM EvaluacionDTO";
        return em.createQuery(query, EvaluacionDTO.class).getResultList();
    }

    public List<EvaluacionDTO> findByAlumno(AlumnoDTO alumno) {
        String query = "FROM EvaluacionDTO e WHERE e.alumno = :alumno";
        return em.createQuery(query, EvaluacionDTO.class)
                .setParameter("alumno", alumno)
                .getResultList();
    }
}
