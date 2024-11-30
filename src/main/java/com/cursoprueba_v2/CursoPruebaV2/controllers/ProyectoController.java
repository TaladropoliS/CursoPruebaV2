package com.cursoprueba_v2.CursoPruebaV2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;

@Controller
public class ProyectoController implements Serializable {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "App Curso");
        return "index";
    }
}
