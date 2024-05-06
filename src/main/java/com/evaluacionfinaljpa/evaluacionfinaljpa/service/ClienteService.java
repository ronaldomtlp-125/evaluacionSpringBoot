package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Cliente;
import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IClienteRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository iClienteRepo;

    //CRUD
    @Override
    public void crearClienteServ(Cliente cliente) {
        iClienteRepo.save(cliente);
    }

    @Override
    public List<Cliente> traerListaClienteServ() {
        return iClienteRepo.findAll();
    }

    @Override
    public Cliente traerClienteServ(Long id_cliente) {
        Cliente clienteAux = null;
        if (iClienteRepo.existsById(id_cliente)) {
            clienteAux = iClienteRepo.findById(id_cliente).orElse(null);
        } else {
            throw new NoSuchElementException("El cliente con ID " + id_cliente + " no existe en la base de datos.");
        }
        return clienteAux;
    }

    @Override
    public void eliminarClienteServ(Long id_cliente) {
        if (iClienteRepo.existsById(id_cliente)) {
            iClienteRepo.deleteById(id_cliente);
        } else {
            throw new NoSuchElementException("El cliente con ID " + id_cliente + " no existe en la base de datos.");
        }
    }

    @Override
    public void editarClienteServ(Long id_cliente, Cliente cliente) {
        Cliente clienteAux = cliente;
        if (iClienteRepo.existsById(id_cliente)) {
            clienteAux.setId_cliente(id_cliente);
            this.crearClienteServ(cliente);
        } else {
            throw new NoSuchElementException("El cliente con ID " + id_cliente + " no existe en la base de datos.");
        }
    }

}
