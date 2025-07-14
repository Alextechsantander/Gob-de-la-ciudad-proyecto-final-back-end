package com.alxtechcode.proyecto_springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alxtechcode.proyecto_springboot.model.Role;
import com.alxtechcode.proyecto_springboot.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Crear roles básicos si no existen
        createRoleIfNotExists("ROLE_ADMIN");
        createRoleIfNotExists("ROLE_USER");
        
        System.out.println("✅ Roles inicializados correctamente");
    }

    private void createRoleIfNotExists(String roleName) {
        if (roleRepository.findByName(roleName).isEmpty()) {
            Role role = new Role();
            role.setName(roleName);
            roleRepository.save(role);
            System.out.println("🔧 Rol creado: " + roleName);
        } else {
            System.out.println("ℹ️ Rol ya existe: " + roleName);
        }
    }
}
