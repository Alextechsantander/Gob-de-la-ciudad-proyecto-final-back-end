package com.alxtechcode.proyecto_springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.alxtechcode.proyecto_springboot.model.Pedido;
import com.alxtechcode.proyecto_springboot.repository.PedidoRepository;

@Service
public class PedidoService implements IPedidoService {

    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        pedido.setEstado("EN_PROCESO");
        return repo.save(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return repo.findAll();
    }

    @Override
    public Pedido buscarPedido(Long id) {
        return repo.findById(id).orElse(null);
    }
}
