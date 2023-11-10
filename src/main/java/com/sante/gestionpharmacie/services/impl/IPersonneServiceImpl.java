package com.sante.gestionpharmacie.services.impl;

import com.sante.gestionpharmacie.dto.PersonneDto;
import com.sante.gestionpharmacie.entities.PersonneEntite;
import com.sante.gestionpharmacie.repositories.PersonneRepository;
import com.sante.gestionpharmacie.services.IPersonneService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IPersonneServiceImpl implements IPersonneService {
    @Autowired
    private PersonneRepository personneRepository;
    @Override
    public void savePersonne(PersonneDto personneDto) {
        PersonneEntite personne = new PersonneEntite();
        personne.setNom(personneDto.nom());
        personne.setPrenom(personneDto.prenom());
        personne.setAdresse(personneDto.adresse());
        personne.setProfession(personneDto.profession());
        personne.setEmail(personneDto.email());
        personne.setTel(personneDto.tel());
        personneRepository.save(personne);

    }

    @Override
    public List<PersonneDto> getAllPersonne() {
        return personneRepository.findAll()
                .stream()
                .map(personne -> {
                    PersonneDto personneDto = new PersonneDto(personne.getId(),personne.getNom(),personne.getPrenom(),personne.getProfession(),personne.getAdresse(),personne.getEmail(),personne.getTel());
                        return personneDto;
                }).collect(Collectors.toList());
    }

    @Override
    public PersonneDto updatePersonne(PersonneDto personneDto) {
         PersonneEntite pers1= new PersonneEntite(personneDto.id(), personneDto.nom(), personneDto.prenom(), personneDto.profession(), personneDto.adresse(), personneDto.email(), personneDto.tel());
         PersonneEntite pers2 = personneRepository.save(pers1);
        return new PersonneDto(pers2.getId(),pers2.getNom(),pers2.getPrenom(),pers2.getProfession(),pers2.getAdresse(),pers2.getEmail(),pers2.getTel());
    }

    @Override
    public void deletePersonne(Long id) {
       personneRepository.deleteById(id);
    }
}
