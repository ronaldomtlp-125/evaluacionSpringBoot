package com.evaluacionfinaljpa.evaluacionfinaljpa.controller;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Venta;
import com.evaluacionfinaljpa.evaluacionfinaljpa.service.IVentaService;
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
public class VentaController {
    
    @Autowired
    private IVentaService iVentaServ;
    
    //CRUD
    @PostMapping("/ventas/crear")
    public void crearVenta(@RequestBody Venta venta){
        iVentaServ.crearVentaServ(venta);
    }
    
    @GetMapping("/ventas")
    @ResponseBody
    public List<Venta> traerListaVenta(){
        return iVentaServ.traerListaVentaServ();
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    @ResponseBody
    public Venta traerVenta(@PathVariable Long codigo_venta){
        return iVentaServ.traerVentaServ(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void eliminarVenta(@PathVariable Long codigo_venta){
        iVentaServ.eliminarVentaServ(codigo_venta);
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public void editarVenta(@PathVariable Long codigo_venta, @RequestBody Venta venta){
        iVentaServ.editarVentaServ(codigo_venta, venta);
    }
}
