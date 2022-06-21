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

    public String retrievePersonaNombresByCodigo(Long codigo){
        return (String) personaRepositorio.findPersonaNombresByCodigo(codigo);
    }

    public List<String> retrieveAllNombres(){
            return (List<String>) personaRepositorio.findAllNombres();
    }
    public Persona retrievePersonaByCedula(String cedula){
        return (Persona) personaRepositorio.finPersonaByCedula(cedula);
    }

    public void save(Persona persona){
            personaRepositorio.save(persona);
    }
}
