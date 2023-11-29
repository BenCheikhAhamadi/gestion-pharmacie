package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.ComptePharmacienEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptePharmacienRepository extends JpaRepository<ComptePharmacienEntite,Long> {
}
