package com.mindhub.homebanking.Modelo;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "PretamosDelCliente")
public class ClientePrestamo {
    @Id
    @GenericGenerator(strategy = "native", name  = "native")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private long id;
    private Double monto;
    private int coutas;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Prestamo_id")
    private Prestamo prestamos;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;



    public  ClientePrestamo(){}
    public ClientePrestamo(Prestamo prestamos, Cliente cliente, Double monto, int coutas) {
        this.prestamos = prestamos;
        this.cliente = cliente;
        this.monto = monto;
        this.coutas = coutas;
    }


    public long getId() {
        return id;
    }

    public Prestamo getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Prestamo prestamos) {
        this.prestamos = prestamos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public int getCoutas() {
        return coutas;
    }

    public void setCoutas(int coutas) {
        this.coutas = coutas;
    }
}
