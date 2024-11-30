package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.CursoDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDAO implements ICursoDAO {

    @Autowired
    private EntityManager em;


    @Override
    public void eliminarCurso(Integer idCurso) {
        CursoDTO curso = buscarPorId(idCurso);
        if (curso != null) {
            em.remove(curso);
        }
    }

    @Override
    public CursoDTO buscarPorId(Integer idCurso) {
        return em.find(CursoDTO.class, idCurso);
    }
}
