package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.Modelo.Transacción;
import com.mindhub.homebanking.Modelo.TipoDeTransacción;

import java.time.LocalDateTime;

public class TransacionDTO {


    private  Double monto;
    private  String descripcion;
    private  LocalDateTime date;
    private TipoDeTransacción type;

    public TransacionDTO(){}
    public TransacionDTO(Transacción transacción) {
        this.type = transacción.getType();
        this.monto = transacción.getMonto();
        this.descripcion = transacción.getDescripcion();
        this.date = transacción.getDate();
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

    public TipoDeTransacción getType() {
        return type;
    }
}
