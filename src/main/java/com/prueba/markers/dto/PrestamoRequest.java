package com.prueba.markers.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PrestamoRequest {

    private Integer id;
    private Integer monto;
    private Integer plazo;
    private String estado;
    private LocalDate fechaSolicitud;
    private LocalDate fechaRespuesta;
    private Integer idUsuario;
    private Integer idAdmin;

}
