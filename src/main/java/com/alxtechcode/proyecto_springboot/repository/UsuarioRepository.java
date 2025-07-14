package com.alxtechcode.proyecto_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alxtechcode.proyecto_springboot.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String name);
}
