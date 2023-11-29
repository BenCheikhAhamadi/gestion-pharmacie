package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.CompteAgentDto;
import com.sante.gestionpharmacie.entities.CompteAgentEntite;
import com.sante.gestionpharmacie.repositories.CompteAgentRepository;
import com.sante.gestionpharmacie.services.ICompteAgentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ICompteAgentServiceImpl implements ICompteAgentService {
    @Autowired
    private CompteAgentRepository compteAgentRepository;
    @Override
    public void saveCompteAgent(CompteAgentDto compteAgentDto) {
        CompteAgentEntite compte = new CompteAgentEntite();
        compte.setId(compteAgentDto.id());
        compte.setLogin(compteAgentDto.login());
        compte.setPassword(compteAgentDto.password());
        compteAgentRepository.save(compte);

    }

    @Override
    public List<CompteAgentDto> getAllCompteAgent() {
        return compteAgentRepository.findAll()
                .stream()
                .map(compte ->{
                    CompteAgentDto compte1 = new CompteAgentDto(compte.getId(), compte.getLogin(), compte.getPassword());
                   return compte1;
                }).collect(Collectors.toList());
    }

    @Override
    public CompteAgentDto updateCompteAgent(CompteAgentDto compteAgentDto) {
        CompteAgentEntite compte3 = new CompteAgentEntite(compteAgentDto.id(),compteAgentDto.login(),compteAgentDto.password());
        CompteAgentEntite compte4 = compteAgentRepository.save(compte3);
        return new CompteAgentDto(compte4.getId(),compte4.getLogin(),compte4.getPassword());
    }

    @Override
    public void deleteCompteAgent(Long id) {
        compteAgentRepository.deleteById(id);

    }
}
