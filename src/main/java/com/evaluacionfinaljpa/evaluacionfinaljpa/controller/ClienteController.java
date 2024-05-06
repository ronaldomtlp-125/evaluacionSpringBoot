package com.evaluacionfinaljpa.evaluacionfinaljpa.controller;

import com.evaluacionfinaljpa.evaluacionfinaljpa.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    IClienteService iClienteServ;
}
