package com.example.pokemon_finalProject.controller;
import com.example.pokemon_finalProject.dto.AuthRequest;
import com.example.pokemon_finalProject.dto.ProfessorDTO;
import com.example.pokemon_finalProject.dto.TreinadorDTO;
import com.example.pokemon_finalProject.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register/professor")
    public ResponseEntity<Map<String, String>> registerProfessor(@Valid @RequestBody ProfessorDTO request) {
        return ResponseEntity.ok(service.registerProfessor(request));
    }
    @PostMapping("/register/treinador")
    public ResponseEntity<Map<String, String>> registerTreinador(@Valid @RequestBody TreinadorDTO request) {
        return ResponseEntity.ok(service.registerTreinador(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}

