package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    IVentaRepository iVentaRepo;
}
