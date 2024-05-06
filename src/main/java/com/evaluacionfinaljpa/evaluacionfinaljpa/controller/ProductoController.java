package com.evaluacionfinaljpa.evaluacionfinaljpa.controller;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import com.evaluacionfinaljpa.evaluacionfinaljpa.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService iProductoServ;
    
    //CRUD
    @PostMapping("/productos/crear")
    public void crearProducto(@RequestBody Producto producto){
        iProductoServ.crearProductoServ(producto);
    }
    
    @GetMapping("/productos")
    @ResponseBody
    public List<Producto> traerListaProducto(){
        return iProductoServ.traerListaProductoServ();
    }
    
    @GetMapping("/productos/{codigo_producto}")
    @ResponseBody
    public Producto traerProducto(@PathVariable Long codigo_producto){
        return iProductoServ.traerProductoServ(codigo_producto);
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void eliminarProducto(@PathVariable Long codigo_producto){
        iProductoServ.eliminarProductoServ(codigo_producto);
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editarProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto){
        iProductoServ.editarProductoServ(codigo_producto, producto);
    }
    
    //Punto 4
    @GetMapping("/productos/falta_stock")
    @ResponseBody
    public List<Producto> traerProductoSinStock(){
        return iProductoServ.traerProductoFaltaStockServ();
    }
}
