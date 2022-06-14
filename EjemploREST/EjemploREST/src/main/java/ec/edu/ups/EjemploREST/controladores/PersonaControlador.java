package ec.edu.ups.EjemploREST.controladores;

import ec.edu.ups.EjemploREST.entidades.Persona;
import ec.edu.ups.EjemploREST.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //notacion de spring
public class PersonaControlador {

    private PersonaServicio personaServicio;

    @Autowired //inyeccion de dependencia
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> getAllPersonas(){
        List<Persona> listaPersonas= personaServicio.findAll();
        return new ResponseEntity<List<Persona>>(listaPersonas, HttpStatus.OK);
    }
}
