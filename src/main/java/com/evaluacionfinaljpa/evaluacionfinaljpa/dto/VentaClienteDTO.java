package com.evaluacionfinaljpa.evaluacionfinaljpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaClienteDTO {

    private Long codigo_venta_venta;
    private Double total_venta;
    private Integer cantidad_producto_venta;
    private String nombre;
    private String apellido;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta_venta, Double total_venta, Integer cantidad_producto_venta, String nombre, String apellido) {
        this.codigo_venta_venta = codigo_venta_venta;
        this.total_venta = total_venta;
        this.cantidad_producto_venta = cantidad_producto_venta;
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
