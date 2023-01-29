package com.mindhub.homebanking.repositorios;


import com.mindhub.homebanking.Modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CuentaRepositorio extends JpaRepository<Cuenta,Long> {
    Cuenta  findByNumero(String numero);
}
