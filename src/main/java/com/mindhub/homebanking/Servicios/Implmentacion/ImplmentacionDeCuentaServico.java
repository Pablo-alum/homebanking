package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.Servicios.ServicoCuenta;
import com.mindhub.homebanking.dtos.CuentaDTO;
import com.mindhub.homebanking.repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplmentacionDeCuentaServico implements ServicoCuenta {

    @Autowired
    CuentaRepositorio cuentaRepositorio;

    @Override
    public List<CuentaDTO> getCuentasDTO() {
        return cuentaRepositorio.findAll().stream().map(cuenta -> new CuentaDTO(cuenta)).collect(Collectors.toList());
    }

    @Override
    public CuentaDTO getCuenta(Long id) {
        return cuentaRepositorio.findById(id).map(cuenta -> new CuentaDTO(cuenta)).orElse(null);

    }



    @Override
    public void CuentaSave(Cuenta cuenta) {
        cuentaRepositorio.save(cuenta);
    }

    @Override
    public Cuenta findByNumero(String numero) {
        return   cuentaRepositorio.findByNumero(numero);

    }
}
