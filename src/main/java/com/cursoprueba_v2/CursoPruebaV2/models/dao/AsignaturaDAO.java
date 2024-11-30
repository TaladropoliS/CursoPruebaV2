package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AsignaturaDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AsignaturaDAO implements IAsignaturaDAO {

    @Autowired
    private EntityManager em;

    public void guardar(AsignaturaDTO asignatura) {
        em.persist(asignatura);
    }

    public AsignaturaDTO buscarPorId(Integer idAsi) {
        return em.find(AsignaturaDTO.class, idAsi);
    }

    public void eliminar(Integer idAsi) {
        AsignaturaDTO asignatura = buscarPorId(idAsi);
        if (asignatura != null) {
            em.remove(asignatura);
        }
    }

    public List<AsignaturaDTO> listarTodos() {
        String query = "FROM AsignaturaDTO";
        return em.createQuery(query, AsignaturaDTO.class).getResultList();
    }
}
