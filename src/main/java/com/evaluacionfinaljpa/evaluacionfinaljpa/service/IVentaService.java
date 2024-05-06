package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.dto.VentaFechaDTO;
import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {

    //CRUD
    public void crearVentaServ(Venta venta);

    public List<Venta> traerListaVentaServ();

    public Venta traerVentaServ(Long codigo_venta);

    public void eliminarVentaServ(Long codigo_venta);

    public void editarVentaServ(Long codigo_venta, Venta venta);
    
    //punto 5
    public List<Producto> traerListProductosVentaServ(Long codigo_venta);
    
    //punto 6
    public VentaFechaDTO traerSumaVentaFechaServ(LocalDate fecha_venta);
}
