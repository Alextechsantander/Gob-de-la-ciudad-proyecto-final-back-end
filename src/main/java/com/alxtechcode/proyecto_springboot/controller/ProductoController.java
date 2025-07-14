package com.alxtechcode.proyecto_springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alxtechcode.proyecto_springboot.model.Producto;
import com.alxtechcode.proyecto_springboot.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private  ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/list")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("/")
    public String crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @PostMapping("/batch")
    public List<Producto> crearProductos(@RequestBody List<Producto> productos ) {
        return productoService.crearProductos(productos);
    }

    @GetMapping("/find/{id}")
    public Producto buscarProductos(@PathVariable Long id) {
        return productoService.buscarPorId(id);
    }

    @PutMapping("/edit/{id}")
    public String editarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        return productoService.editarProducto(id, producto);
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }

}
