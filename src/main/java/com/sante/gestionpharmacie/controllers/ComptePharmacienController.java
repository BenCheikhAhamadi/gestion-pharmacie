package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.ComptePharmacienDto;
import com.sante.gestionpharmacie.entities.ComptePharmacienEntite;
import com.sante.gestionpharmacie.repositories.ComptePharmacienRepository;
import com.sante.gestionpharmacie.services.IComptePharmacienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compte")
public class ComptePharmacienController {
    @Autowired
 private IComptePharmacienService iComptePharmacienService;
  @GetMapping("/all")
   public List<ComptePharmacienDto> getAllComptePharmacien(){
    return   iComptePharmacienService.getAllComptePharmacien();
  }
 @PostMapping("/add")
 public void addComptePharmacien(@RequestBody ComptePharmacienDto comptePharmacienDto){
      iComptePharmacienService.saveComptePharmacien(comptePharmacienDto);
 }
 @PutMapping("/update/{id}")
 public ResponseEntity<?> updateComptePharmacien(@PathVariable Long id,@RequestBody ComptePharmacienDto comptePharmacienDto){
 ComptePharmacienDto C3 = new ComptePharmacienDto(id, comptePharmacienDto.login(), comptePharmacienDto.password());
 ComptePharmacienDto C4 = iComptePharmacienService.updateComptePharmacien(C3);
 return new ResponseEntity<>(C4, HttpStatus.OK);
 }
@DeleteMapping("/delete/{id}")
 public  void deleteComptePharmacien(@PathVariable Long id){
   iComptePharmacienService.deleteComptePharmacien(id);
}


}
