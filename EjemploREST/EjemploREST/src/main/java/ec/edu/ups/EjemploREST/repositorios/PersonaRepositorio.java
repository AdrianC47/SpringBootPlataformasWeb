package ec.edu.ups.EjemploREST.repositorios;

import ec.edu.ups.EjemploREST.entidades.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepositorio extends CrudRepository<Persona, Long> {

}
