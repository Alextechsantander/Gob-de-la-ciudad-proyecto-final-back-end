package com.alxtechcode.proyecto_springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alxtechcode.proyecto_springboot.model.Producto;
import com.alxtechcode.proyecto_springboot.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    @Override
    public String crearProducto(Producto producto) {
        repo.save(producto);
        return "Producto creado correctamente";
    }

    public List<Producto> crearProductos( List<Producto> productos) {
        return repo.saveAll(productos);
    }

    @Override
    public List<Producto> listarProductos() {
        return repo.findAll();
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String editarProducto(Long id, Producto producto) {
        return repo.findById(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            repo.save(p);
            return "Producto actualizado correctamente";
        }).orElse("Producto no encontrado");
    }

    @Override
    public String eliminarProducto(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Producto eliminado correctamente";
        }
        return "Producto no encontrado";
    }
}
