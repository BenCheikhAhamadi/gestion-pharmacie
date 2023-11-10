package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.PersonneDto;
import com.sante.gestionpharmacie.services.IPersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
    private IPersonneService iPersonneService;
    @GetMapping("/all")
   public List<PersonneDto> getAllPersonne(){

        return iPersonneService.getAllPersonne();
   }
   @PostMapping("/add")
public  void addPersonne(@RequestBody PersonneDto personneDto){

        iPersonneService.savePersonne(personneDto);
}
@DeleteMapping("/delete/{id}")
 public  void deletePersonne(@PathVariable Long id){

        iPersonneService.deletePersonne(id);
 }
 @PostMapping("/update/{id}")
 public ResponseEntity<?> updatePersonne(@PathVariable Long id, @RequestBody PersonneDto personneDto){
   PersonneDto pers3 = new PersonneDto(id,personneDto.nom(), personneDto.prenom(), personneDto.profession(),personneDto.adresse(),personneDto.email(), personneDto.tel());
   PersonneDto pers4= iPersonneService.updatePersonne(pers3);
    return new ResponseEntity<>(pers4, HttpStatus.OK);
    }



}
