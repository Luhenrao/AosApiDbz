package com.java02.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.java02.demo.Model.Planeta;

import com.java02.demo.Repository.PlanetaRepository;

@Service
public class PlanetaService {

    @Autowired
    private PlanetaRepository planetaRepository;

    public List<Planeta> getPlanetaByDestruido(Boolean destruido) {
        return planetaRepository.FindByDestruido(destruido);

    }

    public void deleteById(Long id) {
        if (planetaRepository.existsById(id)) {
            planetaRepository.deleteById(id);
        }
    }

    public Planeta updatePlanetaById(Long id, Planeta planetaAtualizado) {
        Optional<Planeta> planetaExistente = planetaRepository.findById(id);

        if (planetaExistente.isPresent()) {
            Planeta planeta = planetaExistente.get();

            planeta.setNome(planetaAtualizado.getNome());
            planeta.setDestruido(planetaAtualizado.getDestruido());
            planetaRepository.save(planeta);

            return planeta;
        } else {
            return null;
        }

    }

    public Planeta savePlaneta(Planeta planeta) {
        return planetaRepository.save(planeta);
    }

    public List<Planeta> getPlanetaList() {
        return planetaRepository.findAll();
    }

}
