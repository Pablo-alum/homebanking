package com.mindhub.homebanking.Servicios;

import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.dtos.CuentaDTO;

import java.util.List;

public interface ServicoCuenta {

    public List<CuentaDTO> getCuentasDTO();


    public CuentaDTO getCuenta(Long id);

    public void CuentaSave(Cuenta cuenta);

    public Cuenta findByNumero(String numero);

}
