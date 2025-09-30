package com.example.pokemon_finalProject.controller;
import com.example.pokemon_finalProject.dto.TreinadorResponseDTO;
import com.example.pokemon_finalProject.dto.UpdateTreinadorRequestDTO;
import com.example.pokemon_finalProject.model.Treinador;
import com.example.pokemon_finalProject.model.Usuario;
import com.example.pokemon_finalProject.repository.UsuarioRepository;
import com.example.pokemon_finalProject.service.TreinadorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/treinadores")
@RequiredArgsConstructor
public class TreinadorController {

    private final TreinadorService treinadorService;
    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<TreinadorResponseDTO> listarTodosOsTreinadores() {
        return treinadorService.findAll().stream()
                .map(treinadorService::mapToResponseDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TreinadorResponseDTO> findById(@PathVariable Integer id) {
        Treinador treinador = treinadorService.findById(id);
        return ResponseEntity.ok(treinadorService.mapToResponseDTO(treinador));
    }
    private void checkOwnershipOrProfessor(Authentication authentication, Integer id) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("Não foi possível verificar a autenticação do utilizador.");
        }
        boolean isProfessor = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equals("ROLE_PROFESSOR"));

        if (isProfessor) {
            return;
        }
        String userEmail = authentication.getName();
        Usuario usuarioLogado = usuarioRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AccessDeniedException("Utilizador autenticado não foi encontrado."));

        if (!usuarioLogado.getId().equals(id)) {
            throw new AccessDeniedException("Acesso negado. Você só pode modificar os seus próprios dados.");
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<TreinadorResponseDTO> patchUpdate(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateTreinadorRequestDTO requestDto,
            Authentication authentication) {
        checkOwnershipOrProfessor(authentication, id);
        Treinador treinadorAtualizado = treinadorService.patchUpdate(id, requestDto);
        TreinadorResponseDTO responseDto = treinadorService.mapToResponseDTO(treinadorAtualizado);

        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id, Authentication authentication) {
        checkOwnershipOrProfessor(authentication, id);
        treinadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

