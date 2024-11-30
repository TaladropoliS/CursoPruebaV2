package com.cursoprueba_v2.CursoPruebaV2.models.dto;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carreras")
public class CarreraDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car")
    private Integer idCar;

    @Column(name = "nom_car")
    private String nomCar;

    @Column(name = "tip_car")
    private String tipCar;

    @Column(name = "dur_car")
    private Integer durCar;

    @OneToOne
    @JoinColumn(name = "dir_car")
    private DirectorDTO director;

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getNomCar() {
        return nomCar;
    }

    public void setNomCar(String nomCar) {
        this.nomCar = nomCar;
    }

    public String getTipCar() {
        return tipCar;
    }

    public void setTipCar(String tipCar) {
        this.tipCar = tipCar;
    }

    public Integer getDurCar() {
        return durCar;
    }

    public void setDurCar(Integer durCar) {
        this.durCar = durCar;
    }

    public DirectorDTO getDirector() {
        return director;
    }

    public void setDirector(DirectorDTO director) {
        this.director = director;
    }
}
