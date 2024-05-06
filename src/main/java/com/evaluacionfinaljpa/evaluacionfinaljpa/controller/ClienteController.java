package com.evaluacionfinaljpa.evaluacionfinaljpa.controller;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Cliente;
import com.evaluacionfinaljpa.evaluacionfinaljpa.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService iClienteServ;
    
    //CRUD
    @PostMapping("/clientes/crear")
    public void crearCliente(@RequestBody Cliente cliente){
        iClienteServ.crearClienteServ(cliente);
    }
    
    @GetMapping("clientes")
    @ResponseBody
    public List<Cliente> traerListaCliente(){
        return iClienteServ.traerListaClienteServ();
    }
    
    @GetMapping("clientes/{id_cliente}")
    @ResponseBody
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return iClienteServ.traerClienteServ(id_cliente);
    }
    
    @DeleteMapping("clientes/eliminar/{id_cliente}")
    public void borrarCLiente(@PathVariable Long id_cliente){
        iClienteServ.borrarClienteServ(id_cliente);
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public void editarCliente(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        iClienteServ.editarClienteServ(id_cliente, cliente);
    }
    
}
