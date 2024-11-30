package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class CursoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cur")
    private Integer idCur;

    @Column(name = "nom_cur")
    private String nomCur;

    @Column(name = "jor_cur")
    private String jorCur;

    @OneToOne
    @JoinColumn(name = "asi_cur")
    private AsignaturaDTO asignaturas;

    @ManyToOne
    @JoinColumn(name = "doc_cur")
    private DocenteDTO docentes;

    @ManyToOne
    @JoinColumn(name = "alu_cur")
    private AlumnoDTO alumnos;

    public Integer getIdCur() {
        return idCur;
    }

    public void setIdCur(Integer idCur) {
        this.idCur = idCur;
    }

    public String getNomCur() {
        return nomCur;
    }

    public void setNomCur(String nomCur) {
        this.nomCur = nomCur;
    }

    public String getJorCur() {
        return jorCur;
    }

    public void setJorCur(String jorCur) {
        this.jorCur = jorCur;
    }

    public AsignaturaDTO getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(AsignaturaDTO asignaturas) {
        this.asignaturas = asignaturas;
    }

    public DocenteDTO getDocentes() {
        return docentes;
    }

    public void setDocentes(DocenteDTO docentes) {
        this.docentes = docentes;
    }

    public AlumnoDTO getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(AlumnoDTO alumnos) {
        this.alumnos = alumnos;
    }


}
