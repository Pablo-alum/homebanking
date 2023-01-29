package com.mindhub.homebanking.Servicios;

import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.Modelo.Tarjeta;
import com.mindhub.homebanking.dtos.TarjetaDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ServicioTarjeta {
    public TarjetaDTO getTarjeta(Long id);
    public List<TarjetaDTO> getTarjetas();
    public void TarjetaSave(Tarjeta tarjeta);
}
