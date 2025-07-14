package com.alxtechcode.proyecto_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alxtechcode.proyecto_springboot.model.Usuario;
import com.alxtechcode.proyecto_springboot.service.AuthService;
import com.alxtechcode.proyecto_springboot.service.JwtService;
import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Inyectamos lo que necesitamos para la autenticación y creación del token
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody Usuario user) {
        authService.registerUser(user.getUsername(), user.getPassword());
        return "Usuario creado con éxito";
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario user) {
        // Autenticamos al usuario con el AuthenticationManager
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        // Si la autenticación es exitosa, generamos el token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtService.generateToken(userDetails);

         // Devolvemos el token en la respuesta
        return ResponseEntity.ok(Map.of("token", jwt));
    }

}

