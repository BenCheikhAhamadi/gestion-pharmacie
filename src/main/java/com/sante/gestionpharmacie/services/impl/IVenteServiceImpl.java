package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.VenteDto;
import com.sante.gestionpharmacie.entities.VenteEntite;
import com.sante.gestionpharmacie.repositories.VenteRepository;
import com.sante.gestionpharmacie.services.IVenteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IVenteServiceImpl implements IVenteService {
    @Autowired
    private  VenteRepository venteRepository;
    @Override
    public void saveVente(VenteDto venteDto) {
        VenteEntite vente = new VenteEntite();
        vente.setDesignation(venteDto.designation());
        vente.setPrix(venteDto.prix());
        vente.setQuantite(venteDto.quantite());
         venteRepository.save(vente);


    }

    @Override
    public List<VenteDto> getAllVente() {
        return venteRepository.findAll()
                .stream()
                .map(vente ->{
                    VenteDto  venteDto = new VenteDto(vente.getId(), vente.getDesignation(), vente.getPrix(), vente.getQuantite());
                  return venteDto;
                }).collect(Collectors.toList());
    }

    @Override
    public VenteDto updateVente(VenteDto venteDto) {
        VenteEntite v1 = new VenteEntite(venteDto.id(), venteDto.designation(), venteDto.prix(), venteDto.quantite());
        VenteEntite v2 = venteRepository.save(v1);
        return new VenteDto(v2.getId(),v2.getDesignation(),v2.getPrix(),v2.getQuantite());
    }

    @Override
    public void deleteVente(Long id) {
       venteRepository.deleteById(id);
    }
}
