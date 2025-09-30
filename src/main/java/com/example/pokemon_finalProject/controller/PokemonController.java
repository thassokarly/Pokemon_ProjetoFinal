package com.example.pokemon_finalProject.controller;
import com.example.pokemon_finalProject.dto.PokemonDTO;
import com.example.pokemon_finalProject.model.Pokemon;
import com.example.pokemon_finalProject.model.Professor;
import com.example.pokemon_finalProject.model.Usuario;
import com.example.pokemon_finalProject.service.PokemonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pokemon")
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listarTodosOsPokemon() {
        return pokemonService.findAll();
    }
    @GetMapping("/tipo/{tipo}")
    public List<Pokemon> listarPokemonPorTipo(@PathVariable String tipo) {
        return pokemonService.findByTipo(tipo);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(pokemonService.findById(id));
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Pokemon> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok(pokemonService.findByNome(nome));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('PROFESSOR')")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        pokemonService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    @PreAuthorize("hasRole('PROFESSOR')")
    public ResponseEntity<Pokemon> criarPokemon(
            @Valid @RequestBody PokemonDTO pokemonDto,
            @AuthenticationPrincipal Usuario usuarioLogado)
    {
        Professor professor = (Professor) usuarioLogado;
        Pokemon pokemonSalvo = pokemonService.criarPokemon(pokemonDto, professor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pokemonSalvo.getNumeroPokedex())
                .toUri();
        return ResponseEntity.created(location).body(pokemonSalvo);
    }
}

