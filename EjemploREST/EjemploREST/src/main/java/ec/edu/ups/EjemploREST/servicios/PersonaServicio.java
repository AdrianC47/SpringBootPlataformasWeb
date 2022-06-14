package ec.edu.ups.EjemploREST.servicios;

import ec.edu.ups.EjemploREST.entidades.Persona;
import ec.edu.ups.EjemploREST.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {
    @Autowired
    private PersonaRepositorio personaRepositorio;

    public List<Persona> findAll(){
        return (List<Persona>) personaRepositorio.findAll();
    }
}
