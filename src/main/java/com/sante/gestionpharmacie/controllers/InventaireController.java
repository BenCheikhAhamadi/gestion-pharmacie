package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.InventaireDto;
import com.sante.gestionpharmacie.services.IInventaireService;
import com.sante.gestionpharmacie.services.impl.IInventaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventaire")
public class InventaireController {
    @Autowired
    private IInventaireService iInventaireService;
    @GetMapping("/all")
    public List<InventaireDto> getAllInventaire(){
        return iInventaireService.getAllInventaire();
    }

    @PostMapping("/add")
     public ResponseEntity<?> addInventaire(@RequestBody InventaireDto inventaireDto){
        iInventaireService.saveInventaire(inventaireDto);
        return new ResponseEntity<>("Inventaire cree avec succes", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateInventaire(@PathVariable Long id,@RequestBody InventaireDto inventaireDto){
        InventaireDto inventaireDto1 = new InventaireDto(id,inventaireDto.prix_vente(), inventaireDto.stock_detail(), inventaireDto.stock_initial(), inventaireDto.stock_restant());
        InventaireDto inventaireDto2 = iInventaireService.updateInventaire(inventaireDto1);
        return new ResponseEntity<>(inventaireDto2,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteInventaire(@PathVariable Long id){
        iInventaireService.deleteInventaire(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
