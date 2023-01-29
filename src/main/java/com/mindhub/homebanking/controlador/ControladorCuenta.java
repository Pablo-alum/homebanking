package com.mindhub.homebanking.controlador;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.Servicios.ServicoCliente;
import com.mindhub.homebanking.Servicios.ServicoCuenta;
import com.mindhub.homebanking.dtos.CuentaDTO;
import com.mindhub.homebanking.repositorios.ClienteRepositorio;
import com.mindhub.homebanking.repositorios.CuentaRepositorio;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ControladorCuenta {

    @Autowired
    private  ServicoCuenta servicoCuenta;
    @Autowired
    private ServicoCliente servicoCliente;



    @GetMapping(value = "/api/cuentas")
        public List<CuentaDTO> getCuentas(){
        return servicoCuenta.getCuentasDTO();
    }

    @GetMapping("/api/cuentas/{id}")
    public CuentaDTO getCuenta(@PathVariable Long id){
        return servicoCuenta.getCuenta(id);
    }



    //appControler
        @PostMapping(path = "/api/cliente/current/cuenta")
        public ResponseEntity<Object> CrearCuenta(Authentication authentication) {
            Cliente cliente = servicoCliente.findByEmail(authentication.getName());

            if (cliente.getCuentas().size() >= 3) {
            return new ResponseEntity<>("No se puden crear mas cuentas", HttpStatus.FORBIDDEN);
             }

            int ramdom = (int) (Math.random() * 1000000);
            servicoCuenta.CuentaSave(new Cuenta("vin:" + ramdom, LocalDateTime.now(), 0, cliente));


            return new ResponseEntity<>("Cuenta creada existosamente",HttpStatus.CREATED);
        }



    }
