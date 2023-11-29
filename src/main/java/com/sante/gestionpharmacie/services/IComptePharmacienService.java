package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.ComptePharmacienDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IComptePharmacienService {
    void saveComptePharmacien(ComptePharmacienDto comptePharmacienDto);
    List<ComptePharmacienDto> getAllComptePharmacien();
    ComptePharmacienDto updateComptePharmacien(ComptePharmacienDto comptePharmacienDto);
    void deleteComptePharmacien(Long id);

}
