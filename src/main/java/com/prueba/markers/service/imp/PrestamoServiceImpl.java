package com.prueba.markers.service.imp;

import com.prueba.markers.dto.PrestamoRequest;
import com.prueba.markers.dto.PrestamoResponse;
import com.prueba.markers.entity.Prestamo;
import com.prueba.markers.entity.Usuario;
import com.prueba.markers.repository.PrestamoRepository;
import com.prueba.markers.repository.UsuarioRepository;
import com.prueba.markers.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoRepository prestamoRepository;


    /***
     * Realiza la creación de una solicitud de prestamo
     * @param prestamoRequest
     * @return prestamoResponse
     */
    @Override
    public PrestamoResponse newLoan(PrestamoRequest prestamoRequest) {

        try{

            Prestamo prestamo = new Prestamo();
            Usuario usuario = new Usuario();

            usuario.setId(prestamoRequest.getIdUsuario());

            prestamo.setEstado("pendiente");
            prestamo.setFechaRespuesta(prestamoRequest.getFechaRespuesta());
            prestamo.setFechaSolicitud(LocalDate.now());
            prestamo.setMonto(prestamoRequest.getMonto());
            prestamo.setPlazo(prestamoRequest.getPlazo());
            prestamo.setIdUsuario(usuario);
            prestamo.setIdAdmin(null);

            Prestamo loanSaved = prestamoRepository.save(prestamo);

            return new PrestamoResponse(

                    loanSaved.getId(),
                    "Solicitud Registrada para aprobación",
                    loanSaved.getFechaSolicitud(),
                    loanSaved.getFechaRespuesta(),
                    loanSaved.getEstado()

            );


        }catch (RuntimeException exception){
            throw new RuntimeException("No es posible registrar la solicitud del prestamo");
        }
    }

    /**
     * Realiza la actualización del estado del prestamo
     * @param prestamoRequest
     * @return
     */
    @Override
    public PrestamoResponse updateLoan(PrestamoRequest prestamoRequest) {
        try{

            Usuario usuario = new Usuario();

            Prestamo prestamo = prestamoRepository.getReferenceById(prestamoRequest.getId());

            usuario.setId(prestamoRequest.getIdAdmin());

            prestamo.setIdAdmin(usuario);
            prestamo.setFechaRespuesta(LocalDate.now());
            prestamo.setEstado(prestamoRequest.getEstado());

            Prestamo prestamoUpdate = prestamoRepository.save(prestamo);

            return new PrestamoResponse(

                    prestamoUpdate.getId(),
                    "Estado Actualizado",
                    prestamoUpdate.getFechaSolicitud(),
                    prestamoUpdate.getFechaRespuesta(),
                    prestamoUpdate.getEstado()
            );

        }catch (RuntimeException ex){
            throw new RuntimeException("No es posible actualizar el estado del prestamo");
        }
    }


    /**
     * Realiza la consulta de un prestamo por Id
     * @param idLoan
     * @return {PrestamoResponse}
     */
    @Override
    public PrestamoResponse statusLoad(Integer idLoan) {
        try {

            Prestamo prestamo = new Prestamo();

            prestamo = prestamoRepository.getReferenceById(idLoan);

            return new PrestamoResponse(

                    prestamo.getId(),
                    "Informacion del prestamo",
                    prestamo.getFechaSolicitud(),
                    prestamo.getFechaRespuesta(),
                    prestamo.getEstado()
            );
        }catch (RuntimeException exception){
            throw new RuntimeException("No Existe solicitud de prestamo");
        }
    }
}
