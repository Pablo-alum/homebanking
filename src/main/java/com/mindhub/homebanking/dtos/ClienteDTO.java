package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.Cliente;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class ClienteDTO {


    private long id;
    private String nombre;
    private String apellido;
    private String email;



    private Set<CuentaDTO> Cuenta = new HashSet<>();
    private Set<ClientePrestamoDTO> clientePrestamo = new HashSet<>();
    private Set<TarjetaDTO> tarjeta = new HashSet<>();


    public ClienteDTO(){}
    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.email = cliente.getEmail();
        this.Cuenta = cliente.getCuentas().stream().map(cuenta -> new CuentaDTO(cuenta)).collect(Collectors.toSet());
       this.clientePrestamo = cliente.getClientePrestamos().stream().map(clientePrestamo -> new ClientePrestamoDTO(clientePrestamo)).collect(Collectors.toSet());
        this.tarjeta = cliente.getTarjeta().stream().map(tarjeta -> new TarjetaDTO(tarjeta)).collect(Collectors.toSet());
    };


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Set<CuentaDTO> getCuenta() {
        return Cuenta;
    }



    public Set<TarjetaDTO> getTarjeta() {
        return tarjeta;
    }

    public Set<ClientePrestamoDTO> getClientePrestamo() {
        return clientePrestamo;
    }
}

