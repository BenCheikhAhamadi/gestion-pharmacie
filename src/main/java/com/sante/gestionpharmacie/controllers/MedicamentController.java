package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.MedicamentDto;
import com.sante.gestionpharmacie.services.IMedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicament")
public class MedicamentController {
   @Autowired
    private IMedicamentService iMedicamentService;

    @GetMapping("/all")
    public List<MedicamentDto> getAllMedicament(){
        return iMedicamentService.getAllMedicament();
    }

    @PostMapping("/add")
    public void addMedicament(@RequestBody MedicamentDto medicamentDto){
        iMedicamentService.saveMedicament(medicamentDto);
    }
    @DeleteMapping("/delete/{id}")
    public  void deleteMedicament(@PathVariable Long id){
        iMedicamentService.deleteMedicament(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMedicament(@PathVariable Long id,@RequestBody MedicamentDto medicamentDto){
       MedicamentDto var1 = new MedicamentDto(medicamentDto.id(), medicamentDto.designation(), medicamentDto.prix(), medicamentDto.quantite(), medicamentDto.date_debut(),medicamentDto.date_fin());
       MedicamentDto var2 = iMedicamentService.updateMedicament(var1);
       return new ResponseEntity<>(var2, HttpStatus.OK);
    }

}
