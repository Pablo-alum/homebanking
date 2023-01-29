package com.mindhub.homebanking.Modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Prestamos")
public class Prestamo {

    @Id
    @GenericGenerator(strategy = "native", name  = "native")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long id;
    private String nombre;
    private  int maxAmount;


    @ElementCollection
    private List<Integer>  cuotas = new ArrayList<>();


    @OneToMany(mappedBy = "prestamos",fetch = FetchType.EAGER)
    private  Set <ClientePrestamo> clientePrestamos = new HashSet<>();


    public Prestamo() {}

    public Prestamo(String nombre, int maxAmount, List<Integer> cuotas) {
        this.nombre = nombre;
        this.maxAmount = maxAmount;
        this.cuotas = cuotas;
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

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public List<Integer> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Integer> cuotas) {
        this.cuotas = cuotas;
    }

    public Set<ClientePrestamo> getClientePrestamos() {
        return clientePrestamos;
    }

    public void setClientePrestamos(Set<ClientePrestamo> clientePrestamos) {
        this.clientePrestamos = clientePrestamos;
    }
}
