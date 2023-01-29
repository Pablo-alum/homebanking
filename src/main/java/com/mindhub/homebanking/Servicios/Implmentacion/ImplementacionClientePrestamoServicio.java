package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.ClientePrestamo;
import com.mindhub.homebanking.Modelo.Transacción;
import com.mindhub.homebanking.Servicios.ServicioClientePrestamo;
import com.mindhub.homebanking.repositorios.ClientePrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;

@Service
public class ImplementacionClientePrestamoServicio implements ServicioClientePrestamo {

    @Autowired
    ClientePrestamoRepositorio clientePrestamoRepositorio;

    @Override
    public void saveCLientePretamo(ClientePrestamo clientePrestamo) {
        clientePrestamoRepositorio.save(clientePrestamo);
    }
}
