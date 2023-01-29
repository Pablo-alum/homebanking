package com.mindhub.homebanking.Modelo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Tarjetas")
public class Tarjeta {

    @GeneratedValue(  strategy = GenerationType.AUTO ,generator = "native")
    @GenericGenerator(name = "native", strategy =  "native")
    @Id
    private  long id;

    private TipoDeTransacciónTarjetas type;

    private String numero;

    private int  codigoSeguridad;

    private LocalDate FechaDeIncio;

    private LocalDate FechaDeVencimiento;

    private String tarjetahabiente;

    private TipoDeColor tipoDeColor;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private Cliente cliente;


    public Tarjeta() {}

    public Tarjeta(TipoDeTransacciónTarjetas type, String numero, int codigoSeguridad, LocalDate fechaDeIncio, LocalDate fechaDeVencimiento, String tarjetahabiente, TipoDeColor tipoDeColor, Cliente cliente) {
        this.type = type;
        this.numero = numero;
        this.codigoSeguridad = codigoSeguridad;
        FechaDeIncio = fechaDeIncio;
        FechaDeVencimiento = fechaDeVencimiento;
        this.tarjetahabiente = tarjetahabiente;
        this.tipoDeColor = tipoDeColor;
        this.cliente = cliente;
    }


    public Tarjeta(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }


    public void setCliente (Cliente cliente){
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoDeTransacciónTarjetas getType() {
        return type;
    }

    public void setType(TipoDeTransacciónTarjetas type) {
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public LocalDate getFechaDeIncio() {
        return FechaDeIncio;
    }

    public void setFechaDeIncio(LocalDate fechaDeIncio) {
        FechaDeIncio = fechaDeIncio;
    }

    public LocalDate getFechaDeVencimiento() {
        return FechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        FechaDeVencimiento = fechaDeVencimiento;
    }

    public String getTarjetahabiente() {
        return tarjetahabiente;
    }

    public void setTarjetahabiente(String tarjetahabiente) {
        this.tarjetahabiente = tarjetahabiente;
    }

    public TipoDeColor getTipoDeColor() {
        return tipoDeColor;
    }

    public void setColorType(TipoDeColor tipoDeColor) {
        this.tipoDeColor = tipoDeColor;
    }
}
