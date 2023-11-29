package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.InventaireDto;
import com.sante.gestionpharmacie.entities.InventaireEntite;
import com.sante.gestionpharmacie.repositories.InventaireRepository;
import com.sante.gestionpharmacie.services.IInventaireService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class IInventaireServiceImpl implements IInventaireService {
    @Autowired
    private InventaireRepository inventaireRepository;
    @Override
    public void saveInventaire(InventaireDto inventaireDto) {
        InventaireEntite inventaire = new InventaireEntite();
        inventaire.setId(inventaireDto.id());
        inventaire.setPrix_vente(inventaireDto.prix_vente());
        inventaire.setStock_detail(inventaireDto.stock_detail());
        inventaire.setStock_initial(inventaireDto.stock_initial());
        inventaire.setStock_restant(inventaireDto.stock_restant());
         inventaireRepository.save(inventaire);

    }

    @Override
    public List<InventaireDto> getAllInventaire() {
        return inventaireRepository.findAll()
                .stream()
                .map(inventaire->{
                    InventaireDto I1 = new InventaireDto(inventaire.getId(), inventaire.getPrix_vente(), inventaire.getStock_detail(), inventaire.getStock_initial(), inventaire.getStock_restant());
                  return I1;
                }).collect(Collectors.toList());
    }

    @Override
    public InventaireDto updateInventaire(InventaireDto inventaireDto) {
        InventaireEntite I2 = new InventaireEntite(inventaireDto.id(),inventaireDto.prix_vente(), inventaireDto.stock_detail(), inventaireDto.stock_initial(), inventaireDto.stock_restant());
        InventaireEntite I4 = inventaireRepository.save(I2);
        return new InventaireDto(I4.getId(),I4.getPrix_vente(),I4.getStock_detail(),I4.getStock_initial(),I4.getStock_restant());
    }

    @Override
    public void deleteInventaire(Long id) {
        inventaireRepository.deleteById(id);

    }
}
