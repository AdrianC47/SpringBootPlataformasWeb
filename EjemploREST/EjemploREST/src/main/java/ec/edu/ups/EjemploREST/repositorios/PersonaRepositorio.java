package ec.edu.ups.EjemploREST.repositorios;

import ec.edu.ups.EjemploREST.entidades.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaRepositorio extends CrudRepository<Persona, Long> {
    @Query("select p.codigo, p.nombres from Persona p where p.codigo = :codigo")
    String findPersonaNombresByCodigo(Long codigo);
    @Query("select p.nombres  from Persona p")
    List<String> findAllNombres();
    @Query("select p  from Persona p where p.cedula = :cedula")
    Persona finPersonaByCedula(String cedula);

}
