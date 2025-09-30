package com.example.pokemon_finalProject.ValidationCustom;
import com.example.pokemon_finalProject.repository.PokemonEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PokemonEmailValidator implements ConstraintValidator<PokemonEmail, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.endsWith("@poke.gmail.br");
    }
}

