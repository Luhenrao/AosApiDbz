package com.projeto.demo.exception;

public class PlanetaNotFoundException extends Exception {
    public PlanetaNotFoundException(String id) {
        super("Planeta não encontrado " + id);
    }
}