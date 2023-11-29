package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.PharmacienDto;
import com.sante.gestionpharmacie.services.IPharmacienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacien")
public class PharmacienController {
    @Autowired
    private IPharmacienService iPharmacienService;
    @GetMapping("/all")
    public List<PharmacienDto> getAllPharmacien(){
        return iPharmacienService.getAllPharmacien();
    }

    @PostMapping("/add")
     public ResponseEntity<?> addPharmacien(@RequestBody PharmacienDto pharmacienDto){
        iPharmacienService.savePharmacien(pharmacienDto);
        return  new ResponseEntity<>("Pharmacen cree avec succe", HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<?> updatePharmacien(@PathVariable Long id,@RequestBody PharmacienDto pharmacienDto){
        PharmacienDto ph1 = new PharmacienDto(id, pharmacienDto.anneeExperience());
        PharmacienDto ph2 = iPharmacienService.updatePharmacien(ph1);
        return new ResponseEntity<>(pharmacienDto,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deletePharmacien(@PathVariable Long id){
        iPharmacienService.deletePharmacien(id);
        return  new ResponseEntity<>(true,HttpStatus.OK);
    }
}
