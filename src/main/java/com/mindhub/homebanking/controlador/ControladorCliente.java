package com.mindhub.homebanking.controlador;


import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.Servicios.ServicoCliente;
import com.mindhub.homebanking.Servicios.ServicoCuenta;
import com.mindhub.homebanking.configuracion.AutenticacionWeb;
import com.mindhub.homebanking.dtos.ClienteDTO;
import com.mindhub.homebanking.repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ControladorCliente {

    @Autowired
    private ServicoCuenta servicoCuenta;
    @Autowired
    private ServicoCliente servicoCliente;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/api/clientes")
        public List<ClienteDTO> getClientes(){
        return servicoCliente.getCLientesDTO();
    }

    @GetMapping("/api/clientes/{id}")
    public ClienteDTO getCliente(@PathVariable Long id){
        return  servicoCliente.getClienteDTO(id);
    }
    @RestController


    public class AppController {





        @PostMapping(path = "/api/clientes/current")
        public ResponseEntity<Object> registro(
                @RequestParam String nombre, @RequestParam String apellido,

                @RequestParam String email, @RequestParam String contraseña) {


            if (nombre.isEmpty()) {
               return new ResponseEntity<>("Falta el nombre", HttpStatus.FORBIDDEN);
            }

            if (apellido.isEmpty()) {
                return new ResponseEntity<>("Falta el apellido", HttpStatus.FORBIDDEN);
            }

            if (email.isEmpty()) {
                return new ResponseEntity<>("Falta el  Emial", HttpStatus.FORBIDDEN);
            }

            if (contraseña.isEmpty()) {
                return new ResponseEntity<>("Falta la  Contraseña", HttpStatus.FORBIDDEN);
            }

            if (servicoCliente.findByEmail(email) != null){
                return new ResponseEntity<>("El email ya esta en uso ",HttpStatus.FORBIDDEN);// 403
            }



            Cliente cliente1 = new Cliente(nombre, apellido, email, passwordEncoder.encode(contraseña));
            servicoCliente.saveCliente(cliente1);

            //Creo la cuenta
            int ramdom = (int) (Math.random() * 99999999);// hasta que limite llega
            String RamdomNumero = String.valueOf(ramdom);
            servicoCuenta.CuentaSave(new Cuenta("VIN" + RamdomNumero, LocalDateTime.now(), 0, cliente1));
            return new ResponseEntity<>("Creado",HttpStatus.CREATED);


        }







        @Autowired
        private AutenticacionWeb autenticacionWeb;
        @GetMapping("/api/clientes/current")
        public ClienteDTO getClienteAutenticado(Authentication authentication) {
            Cliente cliente = servicoCliente.findByEmail(authentication.getName());
            return new ClienteDTO(cliente);

















        }












    }

}

