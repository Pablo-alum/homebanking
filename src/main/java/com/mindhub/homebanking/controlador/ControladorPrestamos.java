package com.mindhub.homebanking.controlador;

import com.mindhub.homebanking.Modelo.*;
import com.mindhub.homebanking.Servicios.*;
import com.mindhub.homebanking.dtos.PrestamoDTO;
import com.mindhub.homebanking.dtos.SolcitudPretamoDTO;
import com.mindhub.homebanking.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ControladorPrestamos {
    @Autowired
    ServicioPretamos servicioPretamos;
    @Autowired
    ServicoCliente servicoCliente;
    @Autowired
    ServicoCuenta servicoCuenta;
    @Autowired
    ServicioTransacciones servicioTransacciones;
    @Autowired
    ServicioClientePrestamo servicioClientePrestamo;





    @GetMapping(value = "/api/prestamos")
    public List<PrestamoDTO> getPrestamos() {
        return servicioPretamos.getPrestamosDTO();
    }

    @GetMapping("/api/prestamos/{id}")
    public PrestamoDTO getPrestamos(@PathVariable Long id) {
        return  servicioPretamos.getPrestamos(id);
    }


    @Transactional
    @PostMapping(path = "/api/prestamos")
    public ResponseEntity<Object> NuevaSolicutdDeprestamo(Authentication authentication, @RequestBody SolcitudPretamoDTO solcitudPretamoDTO) {

        Prestamo prestamoSelecionado = servicioPretamos.pretamofindById(solcitudPretamoDTO.getId());
        Cliente clienteAutenticado = servicoCliente.findByEmail(authentication.getName());
        Cuenta objetoCuenta = servicoCuenta.findByNumero(solcitudPretamoDTO.getCuentaDeDestino());


        if (solcitudPretamoDTO.getId() != prestamoSelecionado.getId()) {
            return new ResponseEntity<>("Por favor selcione un prestamo Dipsonible", HttpStatus.FORBIDDEN);// 403

        }

        if (solcitudPretamoDTO.getMonto() == 0) {
            return new ResponseEntity<>("El monto soliciatado no puede menor a 1", HttpStatus.FORBIDDEN);// 403
        }

        if (solcitudPretamoDTO.getCuotas() == 0) {
            return new ResponseEntity<>("Por favor selecione una cuota valida", HttpStatus.FORBIDDEN);// 403
        }

        if (solcitudPretamoDTO.getId() == null) {
            return new ResponseEntity<>("Por favor selecione un prestamod isponible", HttpStatus.FORBIDDEN);
        }

        if (solcitudPretamoDTO.getMonto() > prestamoSelecionado.getMaxAmount()) {
            return new ResponseEntity<>("Por favor Selecion un monto menor al Monto maximo", HttpStatus.FORBIDDEN);
        }
       if (!prestamoSelecionado.getCuotas().contains(solcitudPretamoDTO.getCuotas())) {
           return new ResponseEntity<>("Por favor Selecione una de las cuotas disponible ", HttpStatus.FORBIDDEN);

        }
        if (objetoCuenta == null) {
            return new ResponseEntity<>("Por favor Selecione una de las cuenta disponiblible", HttpStatus.FORBIDDEN);
        }

        if (!clienteAutenticado.getCuentas().contains(objetoCuenta)) {
            return new ResponseEntity<>("Por favor Selecione una de SUS cuentas", HttpStatus.FORBIDDEN);
        }


        if (prestamoSelecionado.getId() == 9) {
            Double  procentaje = solcitudPretamoDTO.getMonto() * 0.3;
            servicioClientePrestamo.saveCLientePretamo(new ClientePrestamo(prestamoSelecionado,clienteAutenticado, solcitudPretamoDTO.getMonto()+procentaje, solcitudPretamoDTO.getCuotas()));
        }

        if (prestamoSelecionado.getId() == 10) {
            Double  procentaje = solcitudPretamoDTO.getMonto() * 0.2;
            servicioClientePrestamo.saveCLientePretamo(new ClientePrestamo(prestamoSelecionado,clienteAutenticado, solcitudPretamoDTO.getMonto()+procentaje,solcitudPretamoDTO.getCuotas()));
        }


        if (prestamoSelecionado.getId() == 11) {
            Double  procentaje = solcitudPretamoDTO.getMonto() * 0.4;

            servicioClientePrestamo.saveCLientePretamo(new ClientePrestamo(prestamoSelecionado,clienteAutenticado,solcitudPretamoDTO.getMonto()+procentaje,solcitudPretamoDTO.getCuotas()));
        }


        double monto = solcitudPretamoDTO.getMonto();
        Transacción TransaccionCredito = new Transacción(TipoDeTransacción.CREDITO,monto, "préstamo aprobado", LocalDateTime.now());
            objetoCuenta.agrergarTransacion(TransaccionCredito);
        servicioTransacciones.saveTransacciones(TransaccionCredito);

        objetoCuenta.setBalance(objetoCuenta.getBalance() + solcitudPretamoDTO.getMonto());//Agregamos el dinero

        return new ResponseEntity<>("Prestamo Solicitado Con exito", HttpStatus.CREATED);

    }
}