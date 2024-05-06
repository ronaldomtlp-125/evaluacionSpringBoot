package com.evaluacionfinaljpa.evaluacionfinaljpa.service;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Producto;
import com.evaluacionfinaljpa.evaluacionfinaljpa.repository.IProductoRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository iProductoRepo;

    @Override
    public void crearProductoServ(Producto producto) {
        iProductoRepo.save(producto);
    }

    @Override
    public List<Producto> traerListaProductoServ() {
        return iProductoRepo.findAll();
    }

    @Override
    public Producto traerProductoServ(Long codigo_producto) {
        Producto productoAux = null;
        if (iProductoRepo.existsById(codigo_producto)) {
            productoAux = iProductoRepo.findById(codigo_producto).orElse(null);
        } else {
            throw new NoSuchElementException("El producto con código " + codigo_producto + " no existe en la base de datos.");
        }
        return productoAux;
    }

    @Override
    public void eliminarProductoServ(Long codigo_producto) {
        if (iProductoRepo.existsById(codigo_producto)) {
            iProductoRepo.deleteById(codigo_producto);
        } else {
            throw new NoSuchElementException("El producto con código " + codigo_producto + " no existe en la base de datos.");
        }
    }

    @Override
    public void editarProductoServ(Long codigo_producto, Producto producto) {
        Producto productoAux = producto;
        if (iProductoRepo.existsById(codigo_producto)) {
            productoAux.setCodigo_producto(codigo_producto);
            this.crearProductoServ(producto);
        } else {
            throw new NoSuchElementException("El producto con código " + codigo_producto + " no existe en la base de datos.");
        }
    }

}
