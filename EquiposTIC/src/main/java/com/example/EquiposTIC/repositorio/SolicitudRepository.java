package com.example.EquiposTIC.repositorio;

import com.example.EquiposTIC.entidad.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
}
