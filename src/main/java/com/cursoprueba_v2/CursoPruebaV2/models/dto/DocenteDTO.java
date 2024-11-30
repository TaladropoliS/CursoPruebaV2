package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docentes")
public class DocenteDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "run_doc")
    private String runDoc;

    @Column(name = "nom_doc")
    private String nomDoc;

    @Column(name = "ape_doc")
    private String apeDoc;

//    @OneToOne(mappedBy = "docentes")
//    private AsignaturaDTO asignaturas;

//    @OneToMany(mappedBy = "docentes", cascade = CascadeType.ALL, orphanRemoval = true)
//    List<CursoDTO> cursos = new ArrayList<>();


    public String getRunDoc() {
        return runDoc;
    }

    public void setRunDoc(String runDoc) {
        this.runDoc = runDoc;
    }

    public String getNomDoc() {
        return nomDoc;
    }

    public void setNomDoc(String nomDoc) {
        this.nomDoc = nomDoc;
    }

    public String getApeDoc() {
        return apeDoc;
    }

    public void setApeDoc(String apeDoc) {
        this.apeDoc = apeDoc;
    }

//    public AsignaturaDTO getAsignaturas() {
//        return asignaturas;
//    }
//
//    public void setAsignaturas(AsignaturaDTO asignaturas) {
//        this.asignaturas = asignaturas;
//    }
//
//    public List<CursoDTO> getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(List<CursoDTO> cursos) {
//        this.cursos = cursos;
//    }
}
