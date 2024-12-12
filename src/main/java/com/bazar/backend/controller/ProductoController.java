package com.bazar.backend.controller;


import com.bazar.backend.model.Producto;
import com.bazar.backend.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoServ;

    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto producto){
        productoServ.saveProducto(producto);

        return "Producto: " + producto.getNombre() + " creado correctamente.";
    }

    @GetMapping("/productos")
    public List<Producto> traerProductos(){
        return productoServ.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto){
        return productoServ.getProductoById(codigo_producto);
    }


    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        productoServ.deleteProducto(codigo_producto);
        return "Producto con código: " + codigo_producto + " eliminado correctamente.";
    }


    @PutMapping("/productos/editar")
    public Producto editarProducto(@RequestBody Producto producto){
        productoServ.editProducto(producto);
        return productoServ.getProductoById(producto.getCodigo_producto());
    }

    @GetMapping("/productos/falta_stock")
    public List<Producto> falta_stock(){
        return productoServ.stockBajo();
    }
}
