package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import java.util.List;

public interface IProductoService {

    //CRUD
    public void crearProductoServ(Producto producto);

    public List<Producto> traerListaProductoServ();

    public Producto traerProductoServ(Long codigo_producto);

    public void eliminarProductoServ(Long codigo_producto);

    public void editarProductoServ(Long codigo_producto, Producto producto);
   
    //punto 4
    public List<Producto> traerProductoFaltaStockServ();
}
