package com.cursoprueba_v2.CursoPruebaV2.controllers;

import com.cursoprueba_v2.CursoPruebaV2.models.dao.CarreraDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dao.EvaluacionDAO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.AlumnoDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.dto.CarreraDTO;
import com.cursoprueba_v2.CursoPruebaV2.models.services.AlumnoService;
import com.cursoprueba_v2.CursoPruebaV2.models.services.CarreraService;
import com.cursoprueba_v2.CursoPruebaV2.models.services.IAlumnoService;
import com.cursoprueba_v2.CursoPruebaV2.models.services.ICarreraService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;
    @Autowired
    private EvaluacionDAO evaluacionDAO;
    @Autowired
    private CarreraService carreraService;

    @GetMapping("listarAlumnos")
    public String listarAlumnos(Model model) {

        List<AlumnoDTO> alumnos = alumnoService.listarAlumnosDTO();

        model.addAttribute("titulo", "App Curso");
        model.addAttribute("alumnos", alumnos);

        return "listarAlumnos";
    }

    @PostMapping("listarAlumnosFiltrados")
    public String listarAlumnosFiltrados(Model model,
                                         @RequestParam(required = false) String sitFinal,
                                         @RequestParam(required = false) String run) {

        List<AlumnoDTO> alumnos = alumnoService.listarAlumnosDTO();

        if (sitFinal != null && !sitFinal.isEmpty()) {
            model.addAttribute("subTitulo", "Buscando por Situación Final: " + sitFinal);
            alumnos = alumnos.stream().filter(alumno -> sitFinal
                            .equals(alumno.getSituacionFinal()))
                    .collect(Collectors.toList());
        }

        if (run != null && !run.isEmpty()) {
            model.addAttribute("subTitulo", "Buscando por Run: " + run);
            alumnos = alumnos.stream()
                    .filter(alumno -> alumno.getRunAlu().equals(run))
                    .collect(Collectors.toList());
            if (alumnos.isEmpty()) {
                model.addAttribute("run", "");
                model.addAttribute("titulo", "App Curso");
                model.addAttribute("subTitulo", "No se encontraron resultados para la búsqueda");
                return "listarAlumnos";
            }
        }

        model.addAttribute("titulo", "App Curso");
        model.addAttribute("alumnos", alumnos);

        return "listarAlumnos";
    }

    @Transactional
    @PostMapping("/eliminarAlumno")
    public String eliminarAlumno(@RequestParam("run") String run) {
        AlumnoDTO alumno = alumnoService.buscarAlumnoPorId(run);

        alumno.getEvaluaciones().forEach(evaluacion -> evaluacionDAO.eliminar(evaluacion.getIdEva()));

        alumnoService.eliminarAlumno(run);
        return "redirect:/listarAlumnos";
    }

    @GetMapping("/agregarAlumno")
    public String agregarAlumno(Model model) {
        model.addAttribute("titulo", "Agregar un Alumno");
        List<CarreraDTO> carreras = carreraService.listarCarrerasDTO();
        model.addAttribute("carreras", carreras);
        return "form-save";
    }

    @Transactional
    @PostMapping("/agregarAlumno")
    public String guardarAlumno(AlumnoDTO alumno) {
        System.out.println(alumno.toString());
        alumnoService.guardarAlumno(alumno);
        return "redirect:/listarAlumnos";
    }
}
