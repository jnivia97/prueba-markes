package com.prueba.markers.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PrestamoResponse {

    private Integer id;
    private String respuesta;
    private LocalDate fechaSolicitud;
    private LocalDate fechaRespuesta;
    private String estado;

    public PrestamoResponse (){

    }

    public PrestamoResponse(Integer id, String respuesta, LocalDate fechaSolicitud, LocalDate fechaRespuesta, String estado) {
        this.id = id;
        this.respuesta = respuesta;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaRespuesta =  fechaRespuesta;
        this.estado = estado;
    }
}
