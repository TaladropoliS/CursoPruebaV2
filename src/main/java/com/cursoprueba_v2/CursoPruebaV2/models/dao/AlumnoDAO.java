package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlumnoDAO implements IAlumnoDAO {

    @Autowired
    private EntityManager em;

    public List<AlumnoDTO> listarTodos() {
        String query = "FROM AlumnoDTO";
        return em.createQuery(query, AlumnoDTO.class).getResultList();
    }

    public void guardar(AlumnoDTO alumno) {
        if (em.contains(alumno)) {
            em.persist(alumno);
        } else {
            em.merge(alumno);
        }
    }

    public AlumnoDTO buscarPorId(String runAlu) {
        return em.find(AlumnoDTO.class, runAlu);
    }

    public void eliminar(String runAlu) {
        AlumnoDTO alumno = buscarPorId(runAlu);
        if (alumno != null) {
            em.remove(alumno);
        }
    }
}
