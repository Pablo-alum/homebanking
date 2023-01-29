package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource // tipo de dato cliente
public interface ClienteRepositorio extends JpaRepository <Cliente,Long> {
    Cliente  findByEmail(String email);
}
