package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TransacionRepositorio extends JpaRepository<Transaccion,Long> {
}
