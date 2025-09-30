package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.exception.ResourceNotFoundException;
import com.example.pokemon_finalProject.model.Usuario;
import com.example.pokemon_finalProject.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public void deleteById(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar. Usuário não encontrado com o ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}

