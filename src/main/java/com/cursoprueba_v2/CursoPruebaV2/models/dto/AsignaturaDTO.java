package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
public class AsignaturaDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asi")
    private Long idAsi;

    @Column(name = "nom_asi")
    private String nomAsi;

    @Column(name = "tip_asi")
    private String tipAsi;

    @OneToMany(mappedBy = "asignatura", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();

//    @OneToOne(mappedBy = "asignaturas")
//    private CursoDTO cursos;

    public void addEvaluacion(EvaluacionDTO evaluacion) {
        evaluaciones.add(evaluacion);
        evaluacion.setAsignatura(this);
    }

    public void removeEvaluacion(EvaluacionDTO evaluacion) {
        evaluaciones.remove(evaluacion);
        evaluacion.setAsignatura(null);
    }

    public Long getIdAsi() {
        return idAsi;
    }

    public void setIdAsi(Long idAsi) {
        this.idAsi = idAsi;
    }

    public String getNomAsi() {
        return nomAsi;
    }

    public void setNomAsi(String nomAsi) {
        this.nomAsi = nomAsi;
    }

    public String getTipAsi() {
        return tipAsi;
    }

    public void setTipAsi(String tipAsi) {
        this.tipAsi = tipAsi;
    }

    public List<EvaluacionDTO> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionDTO> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

//    public CursoDTO getCursos() {
//        return cursos;
//    }

//    public void setCursos(CursoDTO cursos) {
//        this.cursos = cursos;
//    }
}
