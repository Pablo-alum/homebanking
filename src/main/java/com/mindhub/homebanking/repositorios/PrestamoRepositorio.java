package com.mindhub.homebanking.repositorios;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Modelo.Cuenta;
import com.mindhub.homebanking.Modelo.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PrestamoRepositorio  extends JpaRepository<Prestamo,Long> {


}
