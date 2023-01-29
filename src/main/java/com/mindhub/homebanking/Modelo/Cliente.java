package com.mindhub.homebanking.Modelo;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "Clientes")
public class Cliente {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy =  "native")
    @Id
    private long id;//Propiedades
    private String nombre;
    private String apellido;
    private  String email;
    private  String contraseña;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private Set <Cuenta> cuentas = new HashSet<>();

    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private Set <ClientePrestamo> clientePrestamos = new HashSet<>();
    @OneToMany(mappedBy = "cliente",fetch = FetchType.EAGER)
    private Set <Tarjeta> tarjetas = new HashSet<>();

    public  Cliente(){}

    public Cliente(String nombre, String apellido, String email ,String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
    }


    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }


    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    @JsonIgnore

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }
    @JsonIgnore

    public Set<ClientePrestamo> getClientePrestamos() {
        return clientePrestamos;
    }
    @JsonIgnore

    public Set<Tarjeta>getTarjeta(){
        return tarjetas;
    }









}