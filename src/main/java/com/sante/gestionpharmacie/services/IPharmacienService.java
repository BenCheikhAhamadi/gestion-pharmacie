package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.PharmacienDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPharmacienService {
    void savePharmacien(PharmacienDto pharmacienDto);
    List<PharmacienDto> getAllPharmacien();
    PharmacienDto updatePharmacien(PharmacienDto pharmacienDto);
    void deletePharmacien(Long id);


}
