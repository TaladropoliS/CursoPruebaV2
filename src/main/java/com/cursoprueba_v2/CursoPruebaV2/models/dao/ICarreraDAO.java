package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;

import java.util.List;

public interface ICarreraDAO {

    List<CarreraDTO> listarTodos();

    CarreraDTO buscarPorId(Integer idCar);

}

