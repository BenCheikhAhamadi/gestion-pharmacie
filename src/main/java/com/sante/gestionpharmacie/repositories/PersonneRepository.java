package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.PersonneEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<PersonneEntite,Long> {
}
