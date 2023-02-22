package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.Transacción;
import com.mindhub.homebanking.Modelo.TipoDeTransaccion;

import java.time.LocalDateTime;

public class TransacionDTO {


    private  Double monto;
    private  String descripcion;
    private  LocalDateTime date;
    private TipoDeTransaccion type;

    public TransacionDTO(){}
    public TransacionDTO(Transacción transaccion) {
        this.type = transaccion.getType();
        this.monto = transaccion.getMonto();
        this.descripcion = transaccion.getDescripcion();
        this.date = transaccion.getDate();
    }

    public Double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TipoDeTransaccion getType() {
        return type;
    }
}
