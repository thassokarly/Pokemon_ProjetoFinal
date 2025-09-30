package com.example.pokemon_finalProject.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    @NotBlank(message = "O email não pode ser vazio.")
    @Email(message = "Formato de email inválido.")
    @Size(max = 100, message = "O email não pode exceder 100 caracteres.")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia.")
    @Size(max = 100, message = "A senha não pode exceder 100 caracteres.")
    private String senha;
}
