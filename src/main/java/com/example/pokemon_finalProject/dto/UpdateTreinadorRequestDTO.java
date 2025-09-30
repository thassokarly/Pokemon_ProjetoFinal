package com.example.pokemon_finalProject.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateTreinadorRequestDTO {

    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
    private String nome;
    @Min(value = 0, message = "O número de insígnias não pode ser negativo.")
    @Max(value = 100, message = "O número de insígnias não pode ser maior que 100.")
    private Integer insignias;

}

