package com.cursoprueba_v2.CursoPruebaV2.models.services;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;

import java.util.List;

public interface ICarreraService {

    List<CarreraDTO> listarCarrerasDTO();

    CarreraDTO buscarCarreraPorId(Integer idCar);

}
