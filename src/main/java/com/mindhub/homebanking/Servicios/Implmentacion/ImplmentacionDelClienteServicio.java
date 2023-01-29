package com.mindhub.homebanking.Servicios.Implmentacion;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.Servicios.ServicoCliente;
import com.mindhub.homebanking.dtos.ClienteDTO;
import com.mindhub.homebanking.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImplmentacionDelClienteServicio implements ServicoCliente {

    @Autowired
    ClienteRepositorio clienteRepositorio;

    @Override
    public List<ClienteDTO> getCLientesDTO() {
        return clienteRepositorio.findAll().stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteDTO(Long id) {
        return clienteRepositorio.findById(id).map(cliente -> new ClienteDTO(cliente)).orElse(null);

    }

    @Override
    public Cliente findByEmail(String email) {
      return   clienteRepositorio.findByEmail(email);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);

    }


}
