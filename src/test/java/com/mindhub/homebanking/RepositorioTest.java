package com.mindhub.homebanking;

import com.mindhub.homebanking.Modelo.*;
import com.mindhub.homebanking.repositorios.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class RepositorioTest {
@MockBean
PasswordEncoder passwordEncoder;


    /////TEST DE INTEGRACION//////
    //TEST DE CLIENTES
    @Autowired
    ClienteRepositorio clienteRepositorio;


    @Test
    public void ExiteCLiente() {

        List<Cliente> clientes = clienteRepositorio.findAll();
        assertThat(clientes, is(not(empty())));

    }

    @Test
    public void existeMelbaAdmin() {
        List<Cliente> clientes = clienteRepositorio.findAll();
        assertThat(clientes, hasItem(hasProperty("email", comparesEqualTo("melba@mindhub.com"))));
    }


    // TEST PRESTAMOS
    @Autowired

    PrestamoRepositorio prestamoRepositorio;

    @Test
    public void exitePrestamos() {

        List<Prestamo> prestamos = prestamoRepositorio.findAll();

        assertThat(prestamos, is(not(empty())));

    }



    @Test
    public void exitePrestamosPersonal() {

        List<Prestamo> prestamos = prestamoRepositorio.findAll();

        assertThat(prestamos, hasItem(hasProperty("nombre", is("Personal"))));

    }

    @Test
    public void ExisteUnPrestamoConMOntoDe500000() {

        List<Prestamo> prestamos = prestamoRepositorio.findAll();

        assertThat(prestamos, hasItem(hasProperty("maxAmount", is(500000))));

    }
    @Test
    public void LaCantidadDeCuentas(){
        List<Prestamo> prestamos = prestamoRepositorio.findAll();
        assertThat(prestamos.size(),is(3));
    }

    // TEST Tarjeta
    @Autowired
    TarjetaRepositorio tarjetaRepositorio;

    @Test
    public void exiteTarjetas() {
        List<Tarjeta> tarjetas = tarjetaRepositorio.findAll();

        assertThat(tarjetas, is(not(empty())));
    }

    @Test
    public void TarejtasEsNulo(){
        List<Tarjeta> tarjetas = tarjetaRepositorio.findAll();
        assertThat(tarjetas,is(notNullValue()));
    }

    // TEST Transaccion
    @Autowired
    TransacionRepositorio transacionRepositorio;

    @Test
    public void existeTransacion() {
        List<Transacción> transacciónes = transacionRepositorio.findAll();

        assertThat(transacciónes, is(not(empty())));
    }

    @Test
    public void TodosLosMensjasEstanComentados(){
        List<Transacción> transaccións = transacionRepositorio.findAll();
        assertThat(transaccións,is(notNullValue()));

    }


    // TEST Cuenta
    @Autowired

    CuentaRepositorio cuentaRepositorio;
    @Test
    public void exiteCuentas() {

        List<Cuenta> cuentas = cuentaRepositorio.findAll();

        assertThat(cuentas, is(not(empty())));
    }


    @Test
    public void cuenta() {
        List<Cuenta> cuentas = cuentaRepositorio.findAll();
        assertThat(cuentas, hasItem(hasProperty("numero",is(notNullValue()))));
    }

    //Cliente Pretamo
    @Autowired
    ClientePrestamoRepositorio clientePrestamoRepositorio;


    @Test
    public void ExistenlasCuentas() {
        List <ClientePrestamo> clientePrestamos = clientePrestamoRepositorio.findAll();

        assertThat(clientePrestamos, is(not(nullValue())));
    }

    @Test
    public void ExisteLaPropiedadPrestamos(){
        List <ClientePrestamo> clientePrestamos = clientePrestamoRepositorio.findAll();
        List <Prestamo>  prestamos = prestamoRepositorio.findAll();
        assertThat(clientePrestamos,hasItem(hasProperty("prestamos")));
}

}
