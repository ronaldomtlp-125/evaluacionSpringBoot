package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{
    
    @Autowired
    IProductoRepository iProductoRepo;
}
