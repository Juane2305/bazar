package com.bazar.backend.service;

import com.bazar.backend.model.Cliente;
import com.bazar.backend.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public Cliente getClienteById(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }
}
