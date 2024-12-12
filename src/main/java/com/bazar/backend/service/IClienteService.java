package com.bazar.backend.service;


import com.bazar.backend.model.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> getClientes();

    public void saveCliente(Cliente cliente);

    public Cliente getClienteById(Long id);

    public void deleteCliente(Long id);

    public void editCliente(Cliente cliente);
}
