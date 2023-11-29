package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.CompteAgentEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteAgentRepository extends JpaRepository<CompteAgentEntite,Long> {
}
