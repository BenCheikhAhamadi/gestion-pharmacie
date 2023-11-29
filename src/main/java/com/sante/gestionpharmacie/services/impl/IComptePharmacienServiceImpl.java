package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.ComptePharmacienDto;
import com.sante.gestionpharmacie.entities.ComptePharmacienEntite;
import com.sante.gestionpharmacie.repositories.ComptePharmacienRepository;
import com.sante.gestionpharmacie.services.IComptePharmacienService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IComptePharmacienServiceImpl implements IComptePharmacienService {
    @Autowired
    private ComptePharmacienRepository comptePharmacienRepository;
    @Override
    public void saveComptePharmacien(ComptePharmacienDto comptePharmacienDto) {
        ComptePharmacienEntite compte = new ComptePharmacienEntite();
        compte.setLogin(comptePharmacienDto.login());
        compte.setPassword(comptePharmacienDto.password());
        comptePharmacienRepository.save(compte);
    }

    @Override
    public List<ComptePharmacienDto> getAllComptePharmacien() {
        return comptePharmacienRepository.findAll()
                .stream()
                .map(compte ->{
                    ComptePharmacienDto comptePharmacienDto = new ComptePharmacienDto(compte.getId(), compte.getLogin(), compte.getPassword());
                    return comptePharmacienDto;
                }).collect(Collectors.toList());
    }

    @Override
    public ComptePharmacienDto updateComptePharmacien(ComptePharmacienDto comptePharmacienDto) {
        ComptePharmacienEntite C1 = new ComptePharmacienEntite(comptePharmacienDto.id(), comptePharmacienDto.login(), comptePharmacienDto.password());
        ComptePharmacienEntite C2 = comptePharmacienRepository.save(C1);
        return  new ComptePharmacienDto(C2.getId(),C2.getLogin(),C2.getPassword());
    }

    @Override
    public void deleteComptePharmacien(Long id) {
      comptePharmacienRepository.deleteById(id);
    }
}
