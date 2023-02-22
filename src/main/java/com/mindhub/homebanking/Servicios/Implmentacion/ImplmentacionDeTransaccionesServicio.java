package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.Transaccion;
import com.mindhub.homebanking.Servicios.ServicioTransacciones;
import com.mindhub.homebanking.dtos.TransacionDTO;
import com.mindhub.homebanking.repositorios.TransacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplmentacionDeTransaccionesServicio implements ServicioTransacciones {

    @Autowired
    TransacionRepositorio transacionRepositorio;

    @Override
    public List<TransacionDTO> getTransaccionesDTO() {
        return transacionRepositorio.findAll().stream().map(cuenta -> new TransacionDTO(cuenta)).collect(Collectors.toList());

    }

    @Override
    public TransacionDTO getTransaccionDTO(Long id) {
        return transacionRepositorio.findById(id).map(cuenta -> new TransacionDTO(cuenta)).orElse(null);
    }





    @Override
    public void saveTransacciones(Transaccion transacción) {
        transacionRepositorio.save(transacción);

    }
}
