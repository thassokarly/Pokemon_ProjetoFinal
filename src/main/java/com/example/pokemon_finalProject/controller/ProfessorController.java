package com.example.pokemon_finalProject.controller;
import com.example.pokemon_finalProject.dto.ProfessorResponseDTO;
import com.example.pokemon_finalProject.dto.UpdateProfessorRequestDTO;
import com.example.pokemon_finalProject.model.Professor;
import com.example.pokemon_finalProject.model.Usuario;
import com.example.pokemon_finalProject.repository.UsuarioRepository;
import com.example.pokemon_finalProject.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/professores")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;
    private final UsuarioRepository usuarioRepository;

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> getProfessorComPokemons(@PathVariable Integer id) {
        Professor professor = professorService.findProfessorComPokemons(id);
        return ResponseEntity.ok(professorService.mapToResponseDTO(professor));
    }
    private void checkOwnership(Authentication authentication, Integer id) {
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("Não foi possível verificar a autenticação do utilizador.");
        }
        String userEmail = authentication.getName();
        Usuario usuarioLogado = usuarioRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AccessDeniedException("Utilizador autenticado não foi encontrado."));

        if (!usuarioLogado.getId().equals(id)) {
            throw new AccessDeniedException("Acesso negado. Você só pode modificar os seus próprios dados.");
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> patchUpdate(
            @PathVariable Integer id,
            @Valid @RequestBody UpdateProfessorRequestDTO requestDto,
            Authentication authentication) {

        checkOwnership(authentication, id);
        Professor professorAtualizado = professorService.patchUpdate(id, requestDto);
        ProfessorResponseDTO responseDto = professorService.mapToResponseDTO(professorAtualizado);

        return ResponseEntity.ok(responseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id, Authentication authentication) {
        checkOwnership(authentication, id);
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
