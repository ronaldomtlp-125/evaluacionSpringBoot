package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    IClienteRepository iClienteRepo;
}
