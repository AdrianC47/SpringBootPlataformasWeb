package ec.edu.ups.EjemploREST.controladores;

import ec.edu.ups.EjemploREST.entidades.Direccion;
import ec.edu.ups.EjemploREST.entidades.Persona;
import ec.edu.ups.EjemploREST.entidades.peticiones.direccion.CrearDireccion;
import ec.edu.ups.EjemploREST.entidades.peticiones.persona.CrearPersona;
import ec.edu.ups.EjemploREST.servicios.DireccionServicio;
import ec.edu.ups.EjemploREST.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DireccionControlador {
    private DireccionServicio direccionServicio;
    private PersonaServicio personaServicio;

    @Autowired
    public void setDireccionServicio(DireccionServicio direccionServicio) {
        this.direccionServicio = direccionServicio;
    }
    @Autowired
    public void setPersonaServicio(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    @PostMapping("/direccion/create")
    public ResponseEntity<Direccion> createDireccion(@RequestBody CrearDireccion crearDireccion ){
        Optional <Persona> persona =  personaServicio.findByCodigo(crearDireccion.getCodigoPersona());
        if (persona.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Direccion direccion = new Direccion();
        direccion.setCallePrincipal(crearDireccion.getCallePrincipal());
        direccion.setCalleSecundaria(crearDireccion.getCalleSecundaria());
        direccion.setNumeracion(crearDireccion.getNumeracion());
        direccion.setPersona(persona.get());
        direccionServicio.save(direccion);
        return ResponseEntity.ok(direccion);
    }
    @GetMapping("/direcciones")
    public ResponseEntity<List<Direccion>> getAllDirecciones(){
        List<Direccion> listaDirecciones= direccionServicio.findAll();
        return new ResponseEntity<List<Direccion>>(listaDirecciones, HttpStatus.OK);
    }
}
