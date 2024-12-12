package com.bazar.backend.service;

import com.bazar.backend.model.Producto;
import com.bazar.backend.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepo;

    @Override
    public List<Producto> getProductos() {
        return productoRepo.findAll();
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public Producto getProductoById(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto producto) {
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> stockBajo() {
        List<Producto> productoList = this.getProductos();
        List<Producto> listaStockBajo = new ArrayList<>();
        for (Producto producto: productoList){
            if (producto.getCantidad_disponible() < 5){
                listaStockBajo.add(producto);
            }
        }
        return listaStockBajo;
    }
}
