package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TarjetaRepositorio  extends JpaRepository<Tarjeta,Long> {
}
