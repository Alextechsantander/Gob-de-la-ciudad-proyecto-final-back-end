package com.alxtechcode.proyecto_springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alxtechcode.proyecto_springboot.model.Pedido;
import com.alxtechcode.proyecto_springboot.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping("/")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return service.crearPedido(pedido);
    }

    @GetMapping("/list")
    public List<Pedido> listarPedidos() {
        return service.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return service.buscarPedido(id);
    }

}
