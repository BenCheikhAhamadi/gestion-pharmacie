package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.MedicamentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IMedicamentService {
    void saveMedicament(MedicamentDto medicamentDto);
    List<MedicamentDto>getAllMedicament();
    MedicamentDto updateMedicament(MedicamentDto medicamentDto);
    void deleteMedicament(Long id);
}
