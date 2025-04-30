package com.prueba.markers.service;

import com.prueba.markers.dto.PrestamoRequest;
import com.prueba.markers.dto.PrestamoResponse;
import com.prueba.markers.entity.Prestamo;

public interface PrestamoService {

    PrestamoResponse newLoan(PrestamoRequest prestamoRequest);

    PrestamoResponse updateLoan(PrestamoRequest prestamoRequest);

    PrestamoResponse statusLoad(Integer idLoan);

}
