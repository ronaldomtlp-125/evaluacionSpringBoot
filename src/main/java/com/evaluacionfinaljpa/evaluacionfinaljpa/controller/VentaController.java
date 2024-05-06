package com.evaluacionfinaljpa.evaluacionfinaljpa.controller;

import com.evaluacionfinaljpa.evaluacionfinaljpa.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    IVentaService iVentaServ;
}
