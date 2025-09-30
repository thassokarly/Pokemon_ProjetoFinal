package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.dto.PokemonDTO;
import com.example.pokemon_finalProject.exception.ResourceNotFoundException;
import com.example.pokemon_finalProject.model.Pokemon;
import com.example.pokemon_finalProject.model.Professor;
import com.example.pokemon_finalProject.repository.PokemonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public Pokemon findById(Integer id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pokémon não encontrado com o ID: " + id));
    }
    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }
    public Pokemon findByNome(String nome){
        return pokemonRepository.findByNome(nome)
                .orElseThrow(() -> new ResourceNotFoundException("Pokémon não encontrado com o nome: " + nome));
    }
    public Pokemon criarPokemon(PokemonDTO pokemonDto, Professor professor) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNome(pokemonDto.getNome());
        pokemon.setTipo1(pokemonDto.getTipo1());
        pokemon.setTipo2(pokemonDto.getTipo2());
        pokemon.setHp(pokemonDto.getHp());
        pokemon.setAtaque(pokemonDto.getAtaque());
        pokemon.setDefesa(pokemonDto.getDefesa());
        pokemon.setEspecial(pokemonDto.getEspecial());
        pokemon.setVelocidade(pokemonDto.getVelocidade());
        pokemon.setCriadoPor(professor); // Associa ao criador
        return pokemonRepository.save(pokemon);
    }
    public void deleteById(Integer id) {
        if (!pokemonRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar. Pokémon não encontrado com o ID: " + id);
        }
        pokemonRepository.deleteById(id);
    }
    public List<Pokemon> findByTipo(String tipo) {
        return pokemonRepository.findByTipo1IgnoreCaseOrTipo2IgnoreCase(tipo, tipo);
    }
}
