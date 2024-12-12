package com.bazar.backend.service;


import com.bazar.backend.model.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> getProductos();

    public void saveProducto(Producto producto);

    public Producto getProductoById(Long id);

    public void deleteProducto(Long id);

    public void editProducto(Producto producto);

    public List<Producto> stockBajo();
}
