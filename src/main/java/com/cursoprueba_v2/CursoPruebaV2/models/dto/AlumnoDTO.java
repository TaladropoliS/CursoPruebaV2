package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
public class AlumnoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "run_alu")
    private String runAlu;

    @NotEmpty
    @Column(name = "nom_alu")
    private String nomAlu;

    @NotEmpty
    @Column(name = "ape_alu")
    private String apeAlu;

    @ManyToOne
    @JoinColumn(name = "car_alu", nullable = true)
    private CarreraDTO carrera;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();

    @OneToMany(mappedBy = "alumnos", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoDTO> cursos = new ArrayList<>();

    private Double promedio;
    private String situacionFinal;

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public String getSituacionFinal() {
        return situacionFinal;
    }

    public void setSituacionFinal(String situacionFinal) {
        this.situacionFinal = situacionFinal;
    }

    public void addEvaluacion(EvaluacionDTO evaluacion) {
        evaluaciones.add(evaluacion);
        evaluacion.setAlumno(this);
    }

    public void removeEvaluacion(EvaluacionDTO evaluacion) {
        evaluaciones.remove(evaluacion);
        evaluacion.setAlumno(null);
    }

    public String getRunAlu() {
        return runAlu;
    }

    public void setRunAlu(String runAlu) {
        this.runAlu = runAlu;
    }

    public @NotEmpty String getNomAlu() {
        return nomAlu;
    }

    public void setNomAlu(@NotEmpty String nomAlu) {
        this.nomAlu = nomAlu;
    }

    public @NotEmpty String getApeAlu() {
        return apeAlu;
    }

    public void setApeAlu(@NotEmpty String apeAlu) {
        this.apeAlu = apeAlu;
    }

    public List<EvaluacionDTO> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionDTO> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public List<CursoDTO> getCursos() {
        return cursos;
    }

    public void setCursos(List<CursoDTO> cursos) {
        this.cursos = cursos;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "runAlu='" + runAlu + '\'' +
                ", nomAlu='" + nomAlu + '\'' +
                ", apeAlu='" + apeAlu + '\'' +
                ", carrera=" + carrera +
                ", evaluaciones=" + evaluaciones +
                ", cursos=" + cursos +
                ", promedio=" + promedio +
                ", situacionFinal='" + situacionFinal + '\'' +
                '}';
    }
}
