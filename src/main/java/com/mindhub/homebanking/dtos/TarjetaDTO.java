package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.TipoDeColor;
import com.mindhub.homebanking.Modelo.Tarjeta;
import com.mindhub.homebanking.Modelo.TipoDeTransacciónTarjetas;

import java.time.LocalDate;

public class TarjetaDTO {
    private  long id;


    private TipoDeTransacciónTarjetas type;
    private String numero;
    private int  codigoSeguridad;
    private LocalDate FechaDeIncio;
    private LocalDate FechaDeVencimiento;
    private String tarjetahabiente;
    private TipoDeColor tipoDeColor;

    public TarjetaDTO(Tarjeta tarjeta){
        this.id = tarjeta.getId();
        this.type = tarjeta.getType();
        this.numero = tarjeta.getNumero();
        this.codigoSeguridad = tarjeta.getCodigoSeguridad();
        this.FechaDeIncio = tarjeta.getFechaDeIncio();
        this.FechaDeVencimiento = tarjeta.getFechaDeVencimiento();
        this.tarjetahabiente = tarjeta.getTarjetahabiente();
        this.tipoDeColor = tarjeta.getTipoDeColor();

    }

    public long getId() {
        return id;
    }


    public TipoDeTransacciónTarjetas getType() {
        return type;
    }

    public String getNumero() {
        return numero;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public LocalDate getFechaDeIncio() {
        return FechaDeIncio;
    }

    public LocalDate getFechaDeVencimiento() {
        return FechaDeVencimiento;
    }

    public String getTarjetahabiente() {
        return tarjetahabiente;
    }

    public TipoDeColor getColorType() {
        return tipoDeColor;
    }
}
