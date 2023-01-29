package com.mindhub.homebanking.controlador;


import com.mindhub.homebanking.Modelo.*;
import com.mindhub.homebanking.Servicios.ServicioTransacciones;
import com.mindhub.homebanking.Servicios.ServicoCuenta;
import com.mindhub.homebanking.dtos.TransacionDTO;
import com.mindhub.homebanking.repositorios.CuentaRepositorio;
import com.mindhub.homebanking.repositorios.TransacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController

public class ControladorTransacciones {


    @Autowired

    ServicioTransacciones servicioTransacciones;
    @Autowired
    ServicoCuenta servicoCuenta;


    @GetMapping(value = "/api/transaciones")
    public List<TransacionDTO> getTransacciones() {
        return servicioTransacciones.getTransaccionesDTO();

    }

    @GetMapping("/api/transacion/{id}")
    public TransacionDTO getTransaccion(@PathVariable Long id) {
            return servicioTransacciones.getTransaccionDTO(id);

    }


    @Transactional
    @PostMapping(value = "/api/transaciones")
    public ResponseEntity<Object> CrearTransacion(Authentication authentication, @RequestParam Double monto, @RequestParam String descripción, @RequestParam String numeroDeOrigen, @RequestParam String numeroDeDeDestino) {


        if (numeroDeDeDestino == numeroDeOrigen) {
            return new ResponseEntity<>("No te Pudes transferir a vos mismo", HttpStatus.FORBIDDEN);
        }

        if (monto == 0) {
            return new ResponseEntity<>("Falta el Monto", HttpStatus.FORBIDDEN);

        }
        if (descripción.isEmpty()) {
            return new ResponseEntity<>("Falta La Descripcion", HttpStatus.FORBIDDEN);

        }

        if (numeroDeOrigen.isEmpty()) {
            return new ResponseEntity<>("Falta la cuenta De origne", HttpStatus.FORBIDDEN);

        }

        if (numeroDeDeDestino.isEmpty()) {
            return new ResponseEntity<>("Falta la Cuenta De  Destino ", HttpStatus.FORBIDDEN);
        }



        Transacción TransacciónCREDIT = new Transacción(TipoDeTransacción.CREDITO, monto, descripción, LocalDateTime.now());
        ;// cargar

        Transacción TransacciónDeDEBIT = new Transacción(TipoDeTransacción.DEBITO, -monto, descripción, LocalDateTime.now());
        ;//Debo


        Cuenta CuentaDeOrigen = servicoCuenta.findByNumero(numeroDeOrigen);
        Cuenta CuentaDeDestion = servicoCuenta.findByNumero(numeroDeDeDestino);


        if (CuentaDeOrigen.getBalance() == 0){
            return  new ResponseEntity<>("El monto es vacio",HttpStatus.FORBIDDEN);
        }

        if (CuentaDeOrigen.getBalance() <= monto){
            return  new ResponseEntity<>("No tienes monto suficiente",HttpStatus.FORBIDDEN);
        }

        CuentaDeOrigen.agrergarTransacion(TransacciónDeDEBIT);
        CuentaDeDestion.agrergarTransacion(TransacciónCREDIT);

        CuentaDeOrigen.setBalance(CuentaDeOrigen.getBalance()-monto);
        CuentaDeDestion.setBalance(CuentaDeDestion.getBalance()+monto);

        servicioTransacciones.saveTransacciones(TransacciónCREDIT);
        servicioTransacciones.saveTransacciones(TransacciónDeDEBIT);

        return new ResponseEntity<>("Transaccion Filanisada con exito", HttpStatus.CREATED);

    }
}
