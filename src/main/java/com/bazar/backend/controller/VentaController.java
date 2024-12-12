package com.bazar.backend.controller;

import com.bazar.backend.model.Venta;
import com.bazar.backend.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaServ;

    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta venta){
        ventaServ.saveVenta(venta);

        return "Venta " + venta.getCodigo_venta() + " creada correctamente.";
    }

    @GetMapping("/ventas")
    public List<Venta> traerVentas(){
        return ventaServ.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta){
        return ventaServ.getVentaById(codigo_venta);
    }


    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventaServ.deleteVenta(codigo_venta);
        return "Venta con codigo: " + codigo_venta + " eliminada correctamente.";
    }


    @PutMapping("/ventas/editar")
    public Venta editarVenta(@RequestBody Venta venta){
        ventaServ.editVenta(venta);
        return ventaServ.getVentaById(venta.getCodigo_venta());
    }

    @GetMapping("ventas/productos/{codigo_venta}")
    public void obtenerProductosVenta(@PathVariable Long codigo_venta){
        ventaServ.getProductosVenta(codigo_venta);
    }
}
