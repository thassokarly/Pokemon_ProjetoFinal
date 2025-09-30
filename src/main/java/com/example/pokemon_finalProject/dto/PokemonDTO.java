package com.example.pokemon_finalProject.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class PokemonDTO {
    @NotBlank
    private String nome;
    @NotBlank
    private String tipo1;

    private String tipo2;
    @NotNull
    @Min(1)
    private int hp;

    @NotNull @Min(1)
    private int ataque;

    @NotNull(message = "A defesa не pode ser nula.")
    @Min(value = 1, message = "A defesa deve ser no mínimo 1.")
    private int defesa;

    @NotNull(message = "O especial не pode ser nulo.")
    @Min(value = 1, message = "O especial deve ser no mínimo 1.")
    private int especial;

    @NotNull(message = "A velocidade не pode ser nula.")
    @Min(value = 1, message = "A velocidade deve ser no mínimo 1.")
    private int velocidade;
}
