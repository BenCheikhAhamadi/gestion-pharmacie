package com.sante.gestionpharmacie.repositories;

import com.sante.gestionpharmacie.entities.InventaireEntite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventaireRepository extends JpaRepository<InventaireEntite,Long> {
}
