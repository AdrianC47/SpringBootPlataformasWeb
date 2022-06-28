package ec.edu.ups.EjemploREST.entidades.peticiones.direccion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrearDireccion {
    @JsonProperty
    private String callePrincipal;
    @JsonProperty
    private String calleSecundaria;
    @JsonProperty
    private String numeracion;
    @JsonProperty
    private Long codigoPersona;

    public CrearDireccion() {
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public Long getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Long codigoPersona) {
        this.codigoPersona = codigoPersona;
    }
}
