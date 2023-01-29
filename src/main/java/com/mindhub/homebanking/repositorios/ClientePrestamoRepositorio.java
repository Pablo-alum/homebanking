package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.ClientePrestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.spi.LocaleNameProvider;


@RepositoryRestResource //trasefrnieca de
public interface ClientePrestamoRepositorio extends JpaRepository<ClientePrestamo,Long> {

}
