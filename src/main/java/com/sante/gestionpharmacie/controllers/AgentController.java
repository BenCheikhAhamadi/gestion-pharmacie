package com.sante.gestionpharmacie.controllers;

import com.sante.gestionpharmacie.dto.AgentDto;
import com.sante.gestionpharmacie.services.IAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    private IAgentService iAgentService;
    @GetMapping("/all")
    public List<AgentDto> getAllAgent(){
        return iAgentService.getAllAgent();
    }

    @PostMapping("/add")

    public ResponseEntity<?> addAgent(@RequestBody AgentDto agentDto){
        iAgentService.saveAgent(agentDto);
        return new ResponseEntity<>("Agent cree qvec succ", HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAgent(@PathVariable Long id,@RequestBody AgentDto agentDto){
        AgentDto agentDto1 = new AgentDto(id, agentDto.poste());
        AgentDto agentDto2 = iAgentService.updateAgent(agentDto1);
        return new ResponseEntity<>(agentDto2,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable Long id){
        iAgentService.deleteAgent(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }






}
