package com.alxtechcode.proyecto_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alxtechcode.proyecto_springboot.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
