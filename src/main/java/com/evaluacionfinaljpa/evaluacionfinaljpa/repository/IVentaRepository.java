package com.evaluacionfinaljpa.evaluacionfinaljpa.repository;

import com.evaluacionfinaljpa.evaluacionfinaljpa.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long>{
    
}
