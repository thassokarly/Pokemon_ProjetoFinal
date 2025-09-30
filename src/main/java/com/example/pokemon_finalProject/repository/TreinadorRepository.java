package com.example.pokemon_finalProject.repository;
import com.example.pokemon_finalProject.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Integer> {
}
