package com.prueba.markers.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    private Integer id;
    private String nombre;
    private String email;
    private String password;
    private Boolean admin;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL)
    private List<Prestamo> prestamoUsuario;

    @OneToMany(mappedBy = "idAdmin", cascade = CascadeType.ALL)
    private List<Prestamo> aprobacionAdmin;



}
