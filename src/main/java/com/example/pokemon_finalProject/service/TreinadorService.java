package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.dto.TreinadorResponseDTO;
import com.example.pokemon_finalProject.dto.UpdateTreinadorRequestDTO;
import com.example.pokemon_finalProject.exception.ResourceNotFoundException;
import com.example.pokemon_finalProject.model.Treinador;
import com.example.pokemon_finalProject.repository.TreinadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinadorService {

    private final TreinadorRepository treinadorRepository;

    public List<Treinador> findAll() {
        return treinadorRepository.findAll();
    }
    public Treinador findById(Integer id) {
        return treinadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Treinador não encontrado com o ID: " + id));
    }
    @Transactional
    public Treinador patchUpdate(Integer id, UpdateTreinadorRequestDTO requestDTO) {
        Treinador treinadorExistente = findById(id);

        if (requestDTO.getNome() != null && !requestDTO.getNome().isBlank()) {
            treinadorExistente.setNome(requestDTO.getNome());
        }

        if (requestDTO.getInsignias() != null) {
            treinadorExistente.setInsignias(requestDTO.getInsignias());
        }

        return treinadorRepository.save(treinadorExistente);
    }
    public void deleteById(Integer id) {
        if (!treinadorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar. Treinador não encontrado com o ID: " + id);
        }
        treinadorRepository.deleteById(id);
    }
    public TreinadorResponseDTO mapToResponseDTO(Treinador treinador) {
        return new TreinadorResponseDTO(
                treinador.getId(),
                treinador.getNome(),
                treinador.getEmail(),
                treinador.getInsignias()
        );
    }
}

