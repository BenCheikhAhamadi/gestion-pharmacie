package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.VenteDto;
import com.sante.gestionpharmacie.services.IVenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vente")
public class VenteController {
    @Autowired
    private IVenteService iVenteService;

    @GetMapping("/all")
    public List<VenteDto>getAllVente(){

        return iVenteService.getAllVente();
    }
    @PostMapping("/add")
    public ResponseEntity<?> addVente(@RequestBody VenteDto venteDto){
        iVenteService.saveVente(venteDto);
        return new ResponseEntity<>("Vente creer avec succee",HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateVente(@PathVariable Long id, @RequestBody VenteDto venteDto){
       VenteDto venteDto1 = new VenteDto(id, venteDto.designation(), venteDto.prix(), venteDto.quantite());
        VenteDto venteDto2 = iVenteService.updateVente(venteDto1);
        return new ResponseEntity<>(venteDto2,HttpStatus.OK);
       }
       @DeleteMapping("/{id}")
       public ResponseEntity<?> deleteVente(@PathVariable Long id){
        iVenteService.deleteVente(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
       }

}
