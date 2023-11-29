package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.AgentEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<AgentEntite,Long> {
}
