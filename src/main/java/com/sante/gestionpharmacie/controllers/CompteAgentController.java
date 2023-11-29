package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.CompteAgentDto;
import com.sante.gestionpharmacie.services.ICompteAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compteagent")
public class CompteAgentController {
    @Autowired
    private ICompteAgentService iCompteAgentService;
    @GetMapping("/all")
    public List<CompteAgentDto> getAllCompteAgent(){
        return iCompteAgentService.getAllCompteAgent();
    }

   @PostMapping("/add")
public ResponseEntity<?> addCompteAgent( @RequestBody CompteAgentDto compteAgentDto) {
        iCompteAgentService.saveCompteAgent(compteAgentDto);
        return new ResponseEntity<>("Compte agent cree avec succee",HttpStatus.CREATED);
   }
@PutMapping("/update/{id}")
public  ResponseEntity<?> updateCompteAgent(@PathVariable Long id, @RequestBody CompteAgentDto compteAgentDto) {
        CompteAgentDto C1 = new CompteAgentDto(id, compteAgentDto.login(), compteAgentDto.password());
        CompteAgentDto C2 = iCompteAgentService.updateCompteAgent(C1);
        return new ResponseEntity<>(true,HttpStatus.OK);
}
@DeleteMapping("delete/{id}")
 public ResponseEntity<?> deleteCompteAgent(@PathVariable Long id)   {
        iCompteAgentService.deleteCompteAgent(id);
        return  new ResponseEntity<>(true,HttpStatus.OK);
}

}
