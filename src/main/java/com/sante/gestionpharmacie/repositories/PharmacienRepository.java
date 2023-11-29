package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.PharmacienEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacienRepository extends JpaRepository<PharmacienEntite,Long> {
}
