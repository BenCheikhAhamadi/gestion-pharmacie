package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.CompteAgentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompteAgentService {
    void saveCompteAgent(CompteAgentDto compteAgentDto);
    List<CompteAgentDto> getAllCompteAgent();
    CompteAgentDto updateCompteAgent( CompteAgentDto compteAgentDto);
    void deleteCompteAgent(Long id);
}
