package com.mindhub.homebanking.Servicios;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.Prestamo;
import com.mindhub.homebanking.dtos.PrestamoDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ServicioPretamos {
    public List<PrestamoDTO> getPrestamosDTO();
    public PrestamoDTO getPrestamos(Long id);

    public  Prestamo pretamofindById(Long id);
    public  void savePretamos(Prestamo prestamo);

}
