package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Cliente;
import java.util.List;

public interface IClienteService {
    //CRUD
    public void crearClienteServ(Cliente cliente);
    public Cliente traerClienteServ(Long id_cliente);
    public List<Cliente> traerListaClienteServ();
    public void editarClienteServ(Long id_cliente, Cliente cliente);
    public void borrarClienteServ(Long id_cliente);
}
