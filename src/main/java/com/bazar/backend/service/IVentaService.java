package com.bazar.backend.service;

import com.bazar.backend.model.Producto;
import com.bazar.backend.model.Venta;

import java.util.List;

public interface IVentaService {

    public List<Venta> getVentas();

    public void saveVenta(Venta venta);

    public Venta getVentaById(Long id);

    public void deleteVenta(Long id);

    public void editVenta(Venta venta);

    public List<Producto> getProductosVenta(Long id);

}
