package com.example.pokemon_finalProject.dto;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateProfessorRequestDTO {

    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @Size(min = 2, max = 100, message = "A especialidade deve ter entre 2 e 100 caracteres.")
    private String especialidade;
}
