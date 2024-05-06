package com.evaluacionfinaljpa.evaluacionfinaljpa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Entity
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta; //
    private LocalDate fecha_venta;
    private Double total; //
    @OneToMany(mappedBy = "venta")
    @JsonManagedReference
    private List<Producto> listaProductos; // cantidad, NO lista
    @OneToOne
    @JoinColumn(name = "fk_id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente; //nombre //apellido

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
    
    
}
