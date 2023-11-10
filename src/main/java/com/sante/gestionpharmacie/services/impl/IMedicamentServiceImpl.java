package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.MedicamentDto;
import com.sante.gestionpharmacie.entities.MedicamentEntite;
import com.sante.gestionpharmacie.repositories.MedicamentRepository;
import com.sante.gestionpharmacie.services.IMedicamentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IMedicamentServiceImpl implements IMedicamentService {
    @Autowired
    private MedicamentRepository medicamentRepository;
    @Override
    public void saveMedicament(MedicamentDto medicamentDto) {
        MedicamentEntite medicament = new MedicamentEntite();
        medicament.setDesignation(medicamentDto.designation());
        medicament.setPrix(medicamentDto.prix());
        medicament.setQuantite(medicamentDto.quantite());
        medicament.setDate_debut(medicamentDto.date_debut());
        medicament.setDate_fin(medicamentDto.date_fin());
        medicamentRepository.save(medicament);
    }

    @Override
    public List<MedicamentDto> getAllMedicament() {
        return medicamentRepository.findAll()
                .stream()
                .map(medicament->{
                    MedicamentDto medicamentDto = new MedicamentDto(medicament.getId(), medicament.getDesignation(), medicament.getPrix(), medicament.getQuantite(), medicament.getDate_debut(),medicament.getDate_fin());
                 return medicamentDto;
                }).collect(Collectors.toList());
    }

    @Override
    public MedicamentDto updateMedicament(MedicamentDto medicamentDto) {
        MedicamentEntite medicamentEntite = new MedicamentEntite(medicamentDto.id(),medicamentDto.designation(),medicamentDto.prix(),medicamentDto.quantite(),medicamentDto.date_debut(),medicamentDto.date_fin());
        MedicamentEntite medi = medicamentRepository.save(medicamentEntite);
        return  new MedicamentDto(medi.getId(),medi.getDesignation(),medi.getPrix(),medi.getQuantite(),medi.getDate_debut(),medi.getDate_fin());
    }

    @Override
    public void deleteMedicament(Long id) {
     // medicamentRepository.deleteAllById(id);
    }


}
