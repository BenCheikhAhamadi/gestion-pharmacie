package com.sante.gestionpharmacie.services;

import com.sante.gestionpharmacie.dto.PersonneDto;
import com.sante.gestionpharmacie.entities.PersonneEntite;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IPersonneService {
    void savePersonne(PersonneDto personneDto);
    List<PersonneDto>getAllPersonne();
    PersonneDto updatePersonne(PersonneDto personneDto);
    void deletePersonne(Long id);
}
