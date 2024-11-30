package com.cursoprueba_v2.CursoPruebaV2.models.services;

import com.cursoprueba_v2.CursoPruebaV2.models.dao.ICarreraDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService implements ICarreraService {

    @Autowired
    private ICarreraDAO carreraDAO;

    @Override
    public List<CarreraDTO> listarCarrerasDTO() {
        List<CarreraDTO> carreras = carreraDAO.listarTodos();
        return carreras;
    }

    @Override
    public CarreraDTO buscarCarreraPorId(Integer idCar) {
        return carreraDAO.buscarPorId(idCar);
    }
}
