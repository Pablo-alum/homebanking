package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.ClientePrestamo;
import com.mindhub.homebanking.Modelo.Prestamo;

public class ClientePrestamoDTO {
    private long id;
    private long id_prestamo;
    private String nombre;
    private Double monto;
    private  int Cuotas;

    private Cliente cliente;
    private Prestamo prestamos;

    public ClientePrestamoDTO(){}

    public ClientePrestamoDTO(ClientePrestamo clientePrestamo) {
        this.id = clientePrestamo.getId();
        this.id_prestamo = clientePrestamo.getPrestamos().getId();
        this.nombre = clientePrestamo.getPrestamos().getNombre();
        this.monto = clientePrestamo.getMonto();
        this.Cuotas = clientePrestamo.getCoutas();
        //this.cliente = clientePrestamo.getCliente();
        //this.prestamos = clientePrestamo.getPrestamos();
    }

    public long getId() {
        return id;
    }

    public long getId_prestamo() {
        return id_prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getMonto() {
        return monto;
    }

    public int getCuotas() {
        return Cuotas;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Prestamo getPrestamos() {
        return prestamos;
    }
}
