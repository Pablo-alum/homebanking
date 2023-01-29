package com.mindhub.homebanking.Servicios;

import com.mindhub.homebanking.Modelo.Cliente;
import com.mindhub.homebanking.dtos.ClienteDTO;

import java.util.List;

public interface ServicoCliente {
    public List<ClienteDTO> getCLientesDTO();
    public ClienteDTO getClienteDTO(Long id);

    public Cliente  findByEmail(String email);
    public  void saveCliente(Cliente cliente);
}
