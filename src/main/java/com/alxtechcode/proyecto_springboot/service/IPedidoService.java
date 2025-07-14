package com.alxtechcode.proyecto_springboot.service;

import java.util.List;

import com.alxtechcode.proyecto_springboot.model.Pedido;

public interface IPedidoService {

    Pedido crearPedido(Pedido pedido);
    List<Pedido> listarPedidos();
    Pedido buscarPedido(Long id);

}
