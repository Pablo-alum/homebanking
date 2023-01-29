package com.mindhub.homebanking.Modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "Cuentas")
public class Cuenta {

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Id
    private long id;

    private  String numero;

    private LocalDateTime FechaDeCreacion;

    private double balance;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta",fetch = FetchType.EAGER)
    private Set <Transacción>  transaciones = new HashSet<>();


    public Cuenta(){}

    public Cuenta(String number, LocalDateTime fechaDeCreacion, double balance, Cliente cliente) {
        this.numero = number;
        FechaDeCreacion = fechaDeCreacion;
        this.balance = balance;
        this.cliente = cliente;
    }


    public long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDateTime getFechaDeCreacion() {
        return FechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
        FechaDeCreacion = fechaDeCreacion;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Cuenta(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCliente (Cliente cliente){
        this.cliente = cliente;
    }


    public Set<Transacción> getTransaciones() {
        return transaciones;
    }
    public void  agrergarTransacion(Transacción transacción){
        transacción.setCuenta(this);
        transaciones.add(transacción);
    }







}
