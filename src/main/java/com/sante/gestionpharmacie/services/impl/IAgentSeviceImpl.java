package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.AgentDto;
import com.sante.gestionpharmacie.entities.AgentEntite;
import com.sante.gestionpharmacie.repositories.AgentRepository;
import com.sante.gestionpharmacie.services.IAgentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class IAgentSeviceImpl implements IAgentService {
    @Autowired
    private AgentRepository agentRepository;
    @Override
    public void saveAgent(AgentDto agentDto) {
        AgentEntite agent = new AgentEntite();
        agent.setId(agentDto.id());
        agent.setPoste(agentDto.poste());
        agentRepository.save(agent);
    }

    @Override
    public List<AgentDto> getAllAgent() {
        return agentRepository.findAll()
                .stream()
                .map( agent -> {
                    AgentDto agentDto = new AgentDto(agent.getId(), agent.getPoste());
                    return agentDto;
                }).collect(Collectors.toList());
    }

    @Override
    public AgentDto updateAgent(AgentDto agentDto) {
        AgentEntite agent1 = new AgentEntite(agentDto.id(), agentDto.poste());
        AgentEntite a1 = agentRepository.save(agent1);
        return new AgentDto(a1.getId(),a1.getPoste());
    }

    @Override
    public void deleteAgent(Long id) {
      agentRepository.deleteById(id);
    }
}
