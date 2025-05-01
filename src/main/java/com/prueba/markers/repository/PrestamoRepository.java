package com.prueba.markers.repository;

import com.prueba.markers.entity.Prestamo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE Prestamo p SET p.estado = :estado, p.fechaRespuesta = :fechaRespuesta, p.idAdmin = :idAdmin WHERE p.id = :id")
    int updateStatusLoan(@Param("id") Integer id,
                         @Param("idAdmin") Integer idAdmin,
                         @Param("estado") String estado,
                         @Param("fechaRespuesta") LocalDate fechaRespuesta);


}
