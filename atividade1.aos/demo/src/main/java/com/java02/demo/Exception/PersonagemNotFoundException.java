package com.projeto.demo.exception;

public class PersonagemNotFoundException extends Exception {
    public PersonagemNotFoundException(String id) {
        super("Personagem não encontrado " + id);
    }
}