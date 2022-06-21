package ec.edu.ups.EjemploREST.controladores;

import ec.edu.ups.EjemploREST.entidades.Persona;
import ec.edu.ups.EjemploREST.entidades.peticiones.CrearPersona;
import ec.edu.ups.EjemploREST.servicios.PersonaNoEncontradaException;
import ec.edu.ups.EjemploREST.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{codigo}/nombres")
    public ResponseEntity<String> getNombresByCodigo(@PathVariable Long codigo){
        String nombres = personaServicio.retrievePersonaNombresByCodigo(codigo);
        return  new ResponseEntity<String>(nombres, HttpStatus.OK);
    }

    @GetMapping("/personas/nombres")
    public ResponseEntity<List<String>> getAllNombres(){
        List<String> listaNombres = personaServicio.retrieveAllNombres();
        return  new ResponseEntity<List<String>>(listaNombres, HttpStatus.OK);
    }

    @GetMapping("/persona/{cedula}")
    public ResponseEntity<Persona> getPersonaByCedula(@PathVariable String cedula){
            Optional <Persona> personaOptional = Optional.ofNullable(personaServicio.retrievePersonaByCedula(cedula));
            Persona persona = personaOptional.orElseThrow(PersonaNoEncontradaException::new);
            return new ResponseEntity<Persona>(persona,HttpStatus.OK);
    }

        @PostMapping("/persona/create")
        public ResponseEntity<Persona> createPersona(@RequestBody CrearPersona crearPersona){
            Persona persona = new Persona();


            persona.setNombres(crearPersona.getNombres());
            persona.setApellidos(crearPersona.getApellidos());
            persona.setCedula(crearPersona.getCedula());
            persona.setEdad(crearPersona.getEdad());
            personaServicio.save(persona);
            return ResponseEntity.ok(persona);
        }


}
