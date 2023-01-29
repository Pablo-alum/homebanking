package com.mindhub.homebanking.dtos;

public class SolcitudPretamoDTO {
    private Long id;
    private Double monto;

    private int cuotas;
    private String cuentaDeDestino;


    public int getCuotas() {
        return cuotas;
    }

    public Long getId() {
        return id;
    }


    public Double getMonto() {
        return monto;
    }

    public String getCuentaDeDestino() {
        return cuentaDeDestino;
    }


}
