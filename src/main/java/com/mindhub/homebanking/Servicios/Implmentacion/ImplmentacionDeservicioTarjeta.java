package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.Tarjeta;
import com.mindhub.homebanking.Servicios.ServicioTarjeta;
import com.mindhub.homebanking.dtos.TarjetaDTO;
import com.mindhub.homebanking.repositorios.TarjetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplmentacionDeservicioTarjeta implements ServicioTarjeta {

    @Autowired
    TarjetaRepositorio tarjetaRepositorio;

    @Override
    public TarjetaDTO getTarjeta(Long id) {
        return tarjetaRepositorio.findById(id).map(tarjeta -> new TarjetaDTO(tarjeta)).orElse(null);
    }

    @Override
    public List<TarjetaDTO> getTarjetas() {
        return tarjetaRepositorio.findAll().stream().map(tarjeta -> new TarjetaDTO(tarjeta)).collect(Collectors.toList());

    }

    @Override
    public void TarjetaSave(Tarjeta tarjeta) {
        tarjetaRepositorio.save(tarjeta);
    }

}
