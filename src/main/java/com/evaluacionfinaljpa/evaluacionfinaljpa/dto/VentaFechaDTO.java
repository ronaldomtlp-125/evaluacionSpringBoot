package com.evaluacionfinaljpa.evaluacionfinaljpa.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaFechaDTO {

    private Double montoTotal;
    private Integer cantidadVentas;

    public VentaFechaDTO() {
    }

    public VentaFechaDTO(Double montoTotal, Integer cantidadVentas) {
        this.montoTotal = montoTotal;
        this.cantidadVentas = cantidadVentas;
    }

}
