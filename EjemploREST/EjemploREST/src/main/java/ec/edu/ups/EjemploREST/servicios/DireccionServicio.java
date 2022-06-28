package ec.edu.ups.EjemploREST.servicios;

import ec.edu.ups.EjemploREST.entidades.Direccion;
import ec.edu.ups.EjemploREST.entidades.Persona;
import ec.edu.ups.EjemploREST.repositorios.DireccionRepositorio;
import ec.edu.ups.EjemploREST.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionServicio {

    @Autowired
    DireccionRepositorio direccionRepositorio;
    public void save(Direccion direccion){
        direccionRepositorio.save(direccion);
    }
    public List<Direccion> findAll(){
        return (List<Direccion>) direccionRepositorio.findAll();
    }
}
