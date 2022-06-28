package ec.edu.ups.EjemploREST.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Direccion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;
    @Column(name="calle_principal")
    private String callePrincipal;
    @Column(name="calle_secundaria")
    private String calleSecundaria;
    private String numeracion;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Persona persona;

    public Direccion() {
    }

    public Direccion(long codigo, String callePrincipal, String calleSecundaria, String numeracion, Persona persona) {
        this.codigo = codigo;
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.numeracion = numeracion;
        this.persona = persona;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion = (Direccion) o;
        return codigo == direccion.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "codigo=" + codigo +
                ", callePrincipal='" + callePrincipal + '\'' +
                ", calleSecundaria='" + calleSecundaria + '\'' +
                ", numeracion='" + numeracion + '\'' +
                '}';
    }
}
