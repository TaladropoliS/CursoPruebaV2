package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "evaluaciones")
public class EvaluacionDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_eva")
    private Integer idEva;

    @Column(name = "nom_eva")
    private String nomEva;

    @Column(name = "fec_eva")
    private String fecEva;

    @Column(name = "not_eva")
    private Double notEva;

    @ManyToOne
    @JoinColumn(name = "asi_eva")
    private AsignaturaDTO asignatura;

    @ManyToOne
    @JoinColumn(name = "alu_eva")
    private AlumnoDTO alumno;

    public Integer getIdEva() {
        return idEva;
    }

    public void setIdEva(Integer idEva) {
        this.idEva = idEva;
    }

    public String getNomEva() {
        return nomEva;
    }

    public void setNomEva(String nomEva) {
        this.nomEva = nomEva;
    }

    public String getFecEva() {
        return fecEva;
    }

    public void setFecEva(String fecEva) {
        this.fecEva = fecEva;
    }

    public Double getNotEva() {
        return notEva;
    }

    public void setNotEva(Double notEva) {
        this.notEva = notEva;
    }

    public AsignaturaDTO getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(AsignaturaDTO asignatura) {
        this.asignatura = asignatura;
    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

}
