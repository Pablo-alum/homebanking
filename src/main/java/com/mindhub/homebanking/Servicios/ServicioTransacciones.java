package com.mindhub.homebanking.Servicios;

import com.mindhub.homebanking.Modelo.Transaccion;
import com.mindhub.homebanking.dtos.TransacionDTO;

import java.util.List;

public interface ServicioTransacciones {
    public List<TransacionDTO> getTransaccionesDTO();

    public TransacionDTO getTransaccionDTO(Long id);

    public  void saveTransacciones(Transaccion transacción);

}
