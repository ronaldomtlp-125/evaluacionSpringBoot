package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.dto.VentaClienteDTO;
import com.evaluacionfinaljpa.evaluacionfinaljpa.dto.VentaFechaDTO;
import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Venta;
import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

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
        if (iVentaRepo.existsById(codigo_venta)) {
            ventaAux = iVentaRepo.findById(codigo_venta).orElse(null);
        } else {
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
        return ventaAux;
    }

    @Override
    public void eliminarVentaServ(Long codigo_venta) {
        if (iVentaRepo.existsById(codigo_venta)) {
            iVentaRepo.deleteById(codigo_venta);
        } else {
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
    }

    @Override
    public void editarVentaServ(Long codigo_venta, Venta venta) {
        Venta ventaAux = venta;
        if (iVentaRepo.existsById(codigo_venta)) {
            ventaAux.setCodigo_venta(codigo_venta);
            this.crearVentaServ(ventaAux);
        } else {
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
    }

    // punto 5
    @Override
    public List<Producto> traerListProductosVentaServ(Long codigo_venta) {
        List<Producto> listaProducto = null;

        if (iVentaRepo.existsById(codigo_venta)) {
            listaProducto = this.traerVentaServ(codigo_venta).getListaProductos();
        } else {
            throw new NoSuchElementException("La venta con código " + codigo_venta + " no existe en la base de datos.");
        }
        return listaProducto;
    }

    //punto 6
    @Override
    public VentaFechaDTO traerSumaVentaFechaServ(LocalDate fecha_venta) {
        List<Venta> listaVenta = this.traerListaVentaServ();
        Integer cantidad = 0;
        Double total = 0.0;
        boolean fechaEncontrada = false;

        for (Venta ventaAux : listaVenta) {
            if (ventaAux.getFecha_venta().equals(fecha_venta)) {
                cantidad += 1;
                total += ventaAux.getTotal();
                fechaEncontrada = true;
            }
        }
        if (!fechaEncontrada) {
            throw new NoSuchElementException("La fecha " + fecha_venta + " ingresada no existe en la base de datos.");
        }
        return new VentaFechaDTO(total, cantidad);
    }

    @Override
    public VentaClienteDTO traerDetallesVentaMayorServ() {
        List<Venta> listaVentas = this.traerListaVentaServ();
        Long codigo_venta = 0L;
        double montoMayor = 0.0;
        
        for(Venta ventaAux : listaVentas){
            if(montoMayor < ventaAux.getTotal()){
                codigo_venta = ventaAux.getCodigo_venta();
                montoMayor = ventaAux.getTotal();
            }
        }
        Venta venta = this.traerVentaServ(codigo_venta);
        VentaClienteDTO ventaClienteDTO = new VentaClienteDTO();
        ventaClienteDTO.setApellido(venta.getUnCliente().getApellido());
        ventaClienteDTO.setCantidad_producto_venta(venta.getListaProductos().size());
        ventaClienteDTO.setCodigo_venta_venta(venta.getCodigo_venta());
        ventaClienteDTO.setNombre(venta.getUnCliente().getNombre());
        ventaClienteDTO.setTotal_venta(venta.getTotal());
        
        return ventaClienteDTO;
    }
}
