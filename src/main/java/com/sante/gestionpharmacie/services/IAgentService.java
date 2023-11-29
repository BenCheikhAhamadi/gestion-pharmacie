package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.AgentDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAgentService {
    void saveAgent(AgentDto agentDto);
    List<AgentDto> getAllAgent();
    AgentDto updateAgent( AgentDto agentDto);
    void deleteAgent(Long id);
}
