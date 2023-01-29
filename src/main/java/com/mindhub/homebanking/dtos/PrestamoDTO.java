package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.ClientePrestamo;
import com.mindhub.homebanking.Modelo.Prestamo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PrestamoDTO {

    private long id;
    private String nombre;
    private  int maxAmount;

    private List<Integer> cuotas = new ArrayList<>();
    //private Set<ClientePrestamoDTO> clientePrestamos = new HashSet<>();





    public PrestamoDTO(){};

    public  PrestamoDTO(Prestamo prestamo){
        this.id = prestamo.getId();
        this.nombre = prestamo.getNombre();
        this.maxAmount = prestamo.getMaxAmount();
        this.cuotas = prestamo.getCuotas().stream().collect(Collectors.toList());
       // this.clientePrestamos = prestamo.getClientePrestamos().stream().map(clientePrestamo -> new ClientePrestamoDTO(clientePrestamo)).collect(Collectors.toSet());
    };


    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public List<Integer> getCuotas() {
        return cuotas;
    }

  //  public Set<ClientePrestamoDTO> getClientePrestamos() {
   //     return clientePrestamos;
  //  }
}
