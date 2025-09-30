package com.example.pokemon_finalProject.dto;
import com.example.pokemon_finalProject.repository.PokemonEmail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProfessorDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @PokemonEmail
    @NotBlank(message = "O email é obrigatório.")
    @Size(max = 100, message = "O email não pode exceder 100 caracteres.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres.")
    private String senha;

    @NotBlank(message = "A especialidade é obrigatória.")
    @Size(min = 2, max = 100, message = "A especialidade deve ter entre 2 e 100 caracteres.")
    private String especialidade;
}
