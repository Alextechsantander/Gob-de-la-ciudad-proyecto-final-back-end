package com.alxtechcode.proyecto_springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alxtechcode.proyecto_springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
        Optional<Role> findByName(String name);
}
