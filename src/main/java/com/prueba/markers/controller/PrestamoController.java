package com.prueba.markers.controller;

import com.prueba.markers.dto.PrestamoRequest;
import com.prueba.markers.dto.PrestamoResponse;
import com.prueba.markers.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/loan")
public class PrestamoController {

    @Autowired
    PrestamoService prestamoService;


    @PostMapping("/new")
    public ResponseEntity<PrestamoResponse> crearPrestamo(@RequestBody PrestamoRequest request) {

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(prestamoService.newLoan(request));
        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }


    @PostMapping("/update")
    public ResponseEntity<PrestamoResponse> actualizarEstado(@RequestBody PrestamoRequest request) {

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(prestamoService.updateLoan(request));
        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }

    @GetMapping("/prestamo")
    public ResponseEntity<PrestamoResponse> getPrestamo(@RequestParam Integer idLoan){
        try{

           return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(prestamoService.statusLoad(idLoan));

        }catch (Exception exception){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(null);
        }
    }


}
