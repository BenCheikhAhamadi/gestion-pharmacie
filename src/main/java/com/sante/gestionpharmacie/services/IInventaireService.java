package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.InventaireDto;

import java.util.List;

public interface IInventaireService {
    void saveInventaire(InventaireDto inventaireDto);
    List<InventaireDto> getAllInventaire();
    InventaireDto updateInventaire(InventaireDto inventaireDto);
    void deleteInventaire(Long id);
}
