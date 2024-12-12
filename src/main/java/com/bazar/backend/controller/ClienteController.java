package com.bazar.backend.controller;

import com.bazar.backend.model.Cliente;
import com.bazar.backend.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteServ;

    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cliente){
        clienteServ.saveCliente(cliente);

        return "Cliente " + cliente.getApellido() + " creado correctamente.";
    }

    @GetMapping("/clientes")
    public List<Cliente> traerClientes(){
        return clienteServ.getClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return clienteServ.getClienteById(id_cliente);
    }


    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String eliminarCliente(@PathVariable Long id_cliente){
        clienteServ.deleteCliente(id_cliente);
        return "Cliente con id: " + id_cliente + " eliminado correctamente.";
    }


    @PutMapping("/clientes/editar")
    public Cliente editarCliente(@RequestBody Cliente cliente){
        clienteServ.editCliente(cliente);
        return clienteServ.getClienteById(cliente.getId_cliente());
    }

}
