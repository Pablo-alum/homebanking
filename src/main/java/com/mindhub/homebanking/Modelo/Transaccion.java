package com.mindhub.homebanking.Modelo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transaciones")
public class Transaccion {

    @Id
    @GenericGenerator(strategy = "native", name  = "native")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")

    private long id;

    private TipoDeTransaccion type;
    private Double monto;

    private String descripcion;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="cuenta_id")
    private Cuenta cuenta;


    public Transaccion() {}

    public Transaccion(TipoDeTransaccion type, Double monto, String descripcion, LocalDateTime date) {
        this.type = type;
        this.monto = monto;
        this.descripcion = descripcion;
        this.date = date;
    }


    public long getId() {
        return id;
    }

    public TipoDeTransaccion getType() {
        return type;
    }

    public void setType(TipoDeTransaccion type) {
        this.type = type;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descriocion) {
        this.descripcion = descriocion;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }



    public void setCuenta (Cuenta cuenta){
        this.cuenta = cuenta;
    }
    public Transaccion(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
