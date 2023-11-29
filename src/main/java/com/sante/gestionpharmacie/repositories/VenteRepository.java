package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.VenteEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenteRepository extends JpaRepository<VenteEntite,Long> {
}
