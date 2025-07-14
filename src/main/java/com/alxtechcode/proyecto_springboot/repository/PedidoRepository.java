package com.alxtechcode.proyecto_springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alxtechcode.proyecto_springboot.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
