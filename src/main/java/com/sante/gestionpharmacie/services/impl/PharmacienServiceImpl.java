package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.PharmacienDto;
import com.sante.gestionpharmacie.entities.PharmacienEntite;
import com.sante.gestionpharmacie.repositories.PharmacienRepository;
import com.sante.gestionpharmacie.services.IPharmacienService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PharmacienServiceImpl implements IPharmacienService {
    @Autowired
    private PharmacienRepository pharmacienRepository;

    @Override
    public void savePharmacien(PharmacienDto pharmacienDto) {
        PharmacienEntite pharmacien = new PharmacienEntite();
        pharmacien.setId(pharmacien.getId());
        pharmacien.setAnneeExperience(pharmacienDto.anneeExperience());
        pharmacienRepository.save(pharmacien);

    }

    @Override
    public List<PharmacienDto> getAllPharmacien() {
        return pharmacienRepository.findAll()
                .stream()
                .map(pharmacien ->{
                    PharmacienDto pha = new PharmacienDto(pharmacien.getId(), pharmacien.getAnneeExperience());
                    return  pha;
                }).collect(Collectors.toList());
    }

    @Override
    public PharmacienDto updatePharmacien(PharmacienDto pharmacienDto) {
        PharmacienEntite pharmacienDto1 = new PharmacienEntite(pharmacienDto.id(), pharmacienDto.anneeExperience());
        PharmacienEntite pha3 = pharmacienRepository.save(pharmacienDto1);
        return new PharmacienDto(pharmacienDto.id(), pharmacienDto.anneeExperience());
    }

    @Override
    public void deletePharmacien(Long id) {
      pharmacienRepository.deleteById(id);
    }
}
