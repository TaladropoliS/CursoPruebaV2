package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

@Entity
@Table(name = "directores")
public class DirectorDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "run_dir")
    private String runDir;

    @Column(name = "nom_dir")
    private String nomDir;

    @Column(name = "ape_dir")
    private String apeDir;

    @Column(name = "pro_dir")
    private String proDir;

    @OneToOne(mappedBy = "director")
    private CarreraDTO carrera;

    public String getRunDir() {
        return runDir;
    }

    public void setRunDir(String runDir) {
        this.runDir = runDir;
    }

    public String getNomDir() {
        return nomDir;
    }

    public void setNomDir(String nomDir) {
        this.nomDir = nomDir;
    }

    public String getApeDir() {
        return apeDir;
    }

    public void setApeDir(String apeDir) {
        this.apeDir = apeDir;
    }

    public String getProDir() {
        return proDir;
    }

    public void setProDir(String proDir) {
        this.proDir = proDir;
    }

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }
}
