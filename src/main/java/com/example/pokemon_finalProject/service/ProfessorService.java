package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.dto.ProfessorResponseDTO;
import com.example.pokemon_finalProject.dto.UpdateProfessorRequestDTO;
import com.example.pokemon_finalProject.exception.ResourceNotFoundException;
import com.example.pokemon_finalProject.model.Professor;
import com.example.pokemon_finalProject.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    @Transactional(readOnly = true)
    public Professor findProfessorComPokemons(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com o ID: " + id));
    }
    public Professor findById(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor não encontrado com o ID: " + id));
    }
    @Transactional
    public Professor patchUpdate(Integer id, UpdateProfessorRequestDTO requestDTO) {
        Professor professorExistente = findById(id);

        if (requestDTO.getNome() != null && !requestDTO.getNome().isBlank()) {
            professorExistente.setNome(requestDTO.getNome());
        }
        if (requestDTO.getEspecialidade() != null && !requestDTO.getEspecialidade().isBlank()) {
            professorExistente.setEspecialidade(requestDTO.getEspecialidade());
        }

        return professorRepository.save(professorExistente);
    }
    public void deleteById(Integer id) {
        if (!professorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Não é possível deletar. Professor não encontrado com o ID: " + id);
        }
        professorRepository.deleteById(id);
    }
    public ProfessorResponseDTO mapToResponseDTO(Professor professor) {
        return new ProfessorResponseDTO(
                professor.getId(),
                professor.getNome(),
                professor.getEmail(),
                professor.getEspecialidade()
        );
    }
}
