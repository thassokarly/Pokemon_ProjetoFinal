package com.example.pokemon_finalProject.dto;
import com.example.pokemon_finalProject.repository.PokemonEmail;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TreinadorDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "O email é obrigatório.")
    @PokemonEmail(message = "Formato de email inválido.")
    @Size(max = 100, message = "O email не pode exceder 100 caracteres.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 6, max = 100, message = "A senha deve ter entre 6 e 100 caracteres.")
    private String senha;

    @Min(value = 0, message = "O número de insígnias não pode ser negativo.")
    @Max(value = 100, message = "O número de insígnias não pode ser maior que 100.")
    private Integer insignias;

}
