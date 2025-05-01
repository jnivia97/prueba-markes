package com.prueba.markers.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer monto;
    private Integer plazo;
    private String estado;
    private LocalDate fechaSolicitud;
    private LocalDate fechaRespuesta;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, foreignKey = @ForeignKey(name = "ID_SOLICITANTE_FK"))
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "idAdmin", nullable = true, foreignKey = @ForeignKey(name = "ID_APROBADOR_FK"))
    private Usuario idAdmin;



}
