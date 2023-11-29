package com.sante.gestionpharmacie.dto;

import java.time.LocalDate;
import java.util.Date;

public record MedicamentDto(Long id, LocalDate date_debut,LocalDate date_fin,String designation, String prix, Integer quantite ) {
}
