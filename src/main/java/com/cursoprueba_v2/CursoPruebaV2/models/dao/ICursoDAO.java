package com.cursoprueba_v2.CursoPruebaV2.models.dao;

import com.cursoprueba_v2.CursoPruebaV2.models.dto.CursoDTO;

public interface ICursoDAO {

    void eliminarCurso(Integer idCurso);

    CursoDTO buscarPorId(Integer idCurso);
}
