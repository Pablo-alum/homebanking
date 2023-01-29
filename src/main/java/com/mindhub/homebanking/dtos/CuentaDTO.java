package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.Cuenta;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CuentaDTO {
    private long id;
    private  double balance;
    private  LocalDateTime FechaDeCreacion;
    private  String numero;

    private Set<TransacionDTO> Transacion = new HashSet<>();

    public  CuentaDTO(){}
    public CuentaDTO(Cuenta cuenta){
        this.numero = cuenta.getNumero();
        this.FechaDeCreacion  = cuenta.getFechaDeCreacion();
        this.balance  = cuenta.getBalance();
        this.id  = cuenta.getId();
        this.Transacion = cuenta.getTransaciones().stream().map(transacion -> new TransacionDTO(transacion)).collect(Collectors.toSet());
    }


    public long getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public String getNumero() {
        return numero;
    }


    public Set<TransacionDTO> getTransacion() {
        return Transacion;
    }
}
