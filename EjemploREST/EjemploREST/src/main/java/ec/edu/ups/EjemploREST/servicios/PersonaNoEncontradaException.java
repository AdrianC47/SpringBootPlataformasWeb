package ec.edu.ups.EjemploREST.servicios;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Persona no encontrada!")
public class PersonaNoEncontradaException extends  RuntimeException{
    public PersonaNoEncontradaException(){

    }
    public PersonaNoEncontradaException(String message){ super(message);


    }
}
