package ec.edu.ups.EjemploREST.entidades.peticiones;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearPersona {
    @JsonProperty
    private String cedula;
    @JsonProperty
    private String nombres;
    @JsonProperty
    private String apellidos;
    @JsonProperty
    private int edad;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
