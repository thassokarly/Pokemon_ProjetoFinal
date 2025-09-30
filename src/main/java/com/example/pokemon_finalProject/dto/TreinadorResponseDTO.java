package com.example.pokemon_finalProject.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinadorResponseDTO {
    private Integer id;
    private String nome;
    private String email;
    private Integer insignias;
}

