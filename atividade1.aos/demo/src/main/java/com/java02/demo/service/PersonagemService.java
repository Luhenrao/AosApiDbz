package com.java02.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java02.demo.Model.Personagem;
import com.java02.demo.Repository.PersonagemRepository;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    public List<Personagem> getPersonagensByRaca(String raca) {
        return personagemRepository.findByRaca(raca);
    }

    public void deleteById(Long id) {
        if (personagemRepository.existsById(id)) {
            personagemRepository.deleteById(id);
        }
    }

    public Personagem updatePersonagemById(Long id, Personagem personagemAtualizado) {
        Optional<Personagem> personagemExistente = personagemRepository.findById(id);

        if (personagemExistente.isPresent()) {
            Personagem personagem = personagemExistente.get();

            personagem.setNome(personagemAtualizado.getNome());
            personagem.setRaca(personagemAtualizado.getRaca());
            personagemRepository.save(personagem);

            return personagem;
        } else {
            return null;
        }

    }

    public Personagem savePersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public List<Personagem> getPersonagemList() {
        return personagemRepository.findAll();
    }

}
