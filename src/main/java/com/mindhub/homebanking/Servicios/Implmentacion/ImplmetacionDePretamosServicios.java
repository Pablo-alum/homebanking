package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.Prestamo;
import com.mindhub.homebanking.Servicios.ServicioPretamos;
import com.mindhub.homebanking.Servicios.ServicoCuenta;
import com.mindhub.homebanking.dtos.PrestamoDTO;
import com.mindhub.homebanking.repositorios.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ImplmetacionDePretamosServicios implements ServicioPretamos {

    @Autowired
    PrestamoRepositorio prestamoRepositorio;

    @Override
    public List<PrestamoDTO> getPrestamosDTO() {
        return prestamoRepositorio.findAll().stream().map(prestamo -> new PrestamoDTO(prestamo)).collect(Collectors.toList());

    }

    @Override
    public PrestamoDTO getPrestamos(Long id) {
        return prestamoRepositorio.findById(id).map(prestamo -> new PrestamoDTO(prestamo)).orElse(null);

    }

    @Override
    public Prestamo pretamofindById(Long id) {
        return prestamoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void savePretamos(Prestamo prestamo) {
        prestamoRepositorio.save(prestamo);

    }
}
