package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.VenteDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IVenteService {
    void saveVente(VenteDto venteDto);
     List<VenteDto> getAllVente();
     VenteDto updateVente(VenteDto venteDto);
     void deleteVente(Long id);


}
