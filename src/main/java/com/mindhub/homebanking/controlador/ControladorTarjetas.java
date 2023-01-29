package com.mindhub.homebanking.controlador;


import Utilidades.UtilidadesTarjeta;
import com.mindhub.homebanking.Modelo.*;
import com.mindhub.homebanking.Servicios.ServicioTarjeta;
import com.mindhub.homebanking.Servicios.ServicoCliente;
import com.mindhub.homebanking.dtos.TarjetaDTO;
import com.mindhub.homebanking.repositorios.TarjetaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController

public class ControladorTarjetas {

    @Autowired
    private ServicoCliente servicoCliente;
    @Autowired
    private ServicioTarjeta servicioTarjeta;





    @GetMapping(value = "/api/tarjetas")
    public List<TarjetaDTO> getTarjetas() {
        return servicioTarjeta.getTarjetas();
    }

    @GetMapping("/api/tarjetas/{id}")
    public TarjetaDTO getTarjeta(@PathVariable Long id) {
        return  servicioTarjeta.getTarjeta(id);
    }


    @PostMapping(path = "/api/cliente/current/tarjeta")
    public ResponseEntity<Object> CrearTarjeta(Authentication authentication, @RequestParam TipoDeTransacciónTarjetas tipoDeTransacciónTarjetas,@RequestParam TipoDeColor tipoDeColor) {
        Cliente cliente = servicoCliente.findByEmail(authentication.getName());


        int cvv = UtilidadesTarjeta.getCvv();
        String NumeroTarjeta = UtilidadesTarjeta.getNumeroTarjeta();
        String Nombrehabitante = cliente.getNombre() + cliente.getApellido();


        if (cliente.getTarjeta().stream().filter(tarjeta -> tarjeta.getTipoDeColor().equals(tipoDeColor)).count() >= 3) {
            return new ResponseEntity<>("No se Puden Crear Mas Cuentas", HttpStatus.FORBIDDEN);
        }
        servicioTarjeta.TarjetaSave(new Tarjeta(tipoDeTransacciónTarjetas, NumeroTarjeta, cvv, LocalDate.now(), LocalDate.now().plusYears(5), Nombrehabitante.toUpperCase(), tipoDeColor, cliente));


        return new ResponseEntity<>("Tarejeta Creada",HttpStatus.CREATED);

    }


}
