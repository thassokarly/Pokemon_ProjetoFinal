package com.example.pokemon_finalProject.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        List<String> validationErrors
) {}