package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.Transacción;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransacionRepositorio extends JpaRepository<Transacción,Long> {
}
