package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.MedicamentEntite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends JpaRepository<MedicamentEntite,Long>  {
}
