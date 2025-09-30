package com.example.pokemon_finalProject.repository;
import com.example.pokemon_finalProject.ValidationCustom.PokemonEmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PokemonEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PokemonEmail {
    String message() default "{pokemonEmail.invalid}";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
