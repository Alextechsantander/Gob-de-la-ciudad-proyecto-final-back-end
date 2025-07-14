package com.alxtechcode.proyecto_springboot.service;

import java.util.List;

import com.alxtechcode.proyecto_springboot.model.Producto;

public interface IProductoService {
    String crearProducto(Producto producto);
    List<Producto> listarProductos();
    Producto buscarPorId(Long id);
    String editarProducto(Long id, Producto producto);
    String eliminarProducto(Long id);

}
