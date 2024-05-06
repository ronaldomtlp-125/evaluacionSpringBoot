package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Venta;
import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IVentaRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    
    @Autowired
    private IVentaRepository iVentaRepo;

    // CRUD
    @Override
    public void crearVentaServ(Venta venta) {
        iVentaRepo.save(venta);
    }

    @Override
    public List<Venta> traerListaVentaServ() {
        return iVentaRepo.findAll();
    }

    @Override
    public Venta traerVentaServ(Long codigo_venta) {
        Venta ventaAux = null;
        if(iVentaRepo.existsById(codigo_venta)){
            ventaAux = iVentaRepo.findById(codigo_venta).orElse(null);
        } else{
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
        return ventaAux;
    }

    @Override
    public void eliminarVentaServ(Long codigo_venta) {
        if(iVentaRepo.existsById(codigo_venta)){
            iVentaRepo.deleteById(codigo_venta);
        } else{
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
    }

    @Override
    public void editarVentaServ(Long codigo_venta, Venta venta) {
        Venta ventaAux = venta;
        if(iVentaRepo.existsById(codigo_venta)){
            ventaAux.setCodigo_venta(codigo_venta);
            this.crearVentaServ(ventaAux);
        } else{
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
    }

    @Override
    public List<Producto> traerListProductosVentaServ(Long codigo_venta) {
        List<Producto> listaProducto = null;
        
        if(iVentaRepo.existsById(codigo_venta)){
            listaProducto = this.traerVentaServ(codigo_venta).getListaProductos();
        } else{
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
        return listaProducto;
    }
}
