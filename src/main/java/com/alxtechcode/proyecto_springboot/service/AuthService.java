package com.alxtechcode.proyecto_springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alxtechcode.proyecto_springboot.model.Role;
import com.alxtechcode.proyecto_springboot.model.Usuario;
import com.alxtechcode.proyecto_springboot.repository.RoleRepository;
import com.alxtechcode.proyecto_springboot.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registerUser(String username, String rawPassword) {
        Role userRole = roleRepo.findByName("ROLE_USER")
                .orElseGet(() -> roleRepo.save(new Role(null, "ROLE_USER")));

        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRoles(List.of(userRole));

        return userRepo.save(user);
    }

    public Optional<Usuario> authenticate(String username, String password) {
        Optional<Usuario> userOpt = userRepo.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return userOpt;
        }
        return Optional.empty();
    }

}
