package com.bazar.backend.repository;

import com.bazar.backend.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository <Venta, Long> {
}
