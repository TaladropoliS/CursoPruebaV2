package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarreraDAO implements ICarreraDAO {

    @Autowired
    private EntityManager em;

    public List<CarreraDTO> listarTodos() {
        String query = "FROM CarreraDTO";
        return em.createQuery(query, CarreraDTO.class).getResultList();
    }

    @Override
    public CarreraDTO buscarPorId(Integer idCar) {
        return em.find(CarreraDTO.class, idCar);
    }
}
