package com.java02.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java02.demo.Model.Personagem;
import com.java02.demo.service.PersonagemService;

@RestController
@RequestMapping("/Personagem")
public class PersonagemController {
    
    @Autowired
    private PersonagemService personagemService;


    @PutMapping("/{id}")
public ResponseEntity<Personagem> updatePersonagem(@PathVariable Long id, @RequestBody Personagem persDeta) {
        personagemService.updatePersonagemById(id, persDeta);
        return new ResponseEntity<>(persDeta, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePersonagem(@PathVariable Long id) {
        personagemService.deleteById(id);
        return null;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Personagem> savePersonagem(@RequestBody Personagem personagem) {
       Personagem personagemSalvo = personagemService.savePersonagem(personagem);
        return new ResponseEntity<>(personagemSalvo, HttpStatus.CREATED);
    }
}

