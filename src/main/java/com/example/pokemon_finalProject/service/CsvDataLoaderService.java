package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.model.Pokemon;
import com.example.pokemon_finalProject.repository.PokemonRepository;
import com.opencsv.CSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@Component
public class CsvDataLoaderService implements CommandLineRunner {

    private PokemonRepository pokemonRepository;

    public CsvDataLoaderService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    @Override
    public void run(String... args) {
        if (pokemonRepository.count() > 0) {
            System.out.println(">>> Banco de dados já populado. Pokédex pronta!");
            return;
        }

        System.out.println(">>> Carregando dados COMPLETOS do CSV...");

        try (Reader reader = new InputStreamReader(new ClassPathResource("FirstGenPokemon.csv").getInputStream());
             CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> records = csvReader.readAll();
            records.remove(0);

            for (String[] record : records) {
                Pokemon pokemon = new Pokemon();

                try {
                    pokemon.setNumeroPokedex(Integer.parseInt(record[0]));
                    pokemon.setNome(record[1]);
                    pokemon.setTipo1(record[3]);
                    pokemon.setTipo2(record[4]);
                    pokemon.setHp(Integer.parseInt(record[13]));
                    pokemon.setAtaque(Integer.parseInt(record[14]));
                    pokemon.setDefesa(Integer.parseInt(record[15]));
                    pokemon.setEspecial(Integer.parseInt(record[16]));
                    pokemon.setVelocidade(Integer.parseInt(record[17]));

                    pokemonRepository.save(pokemon);

                } catch (NumberFormatException e) {
                    System.err.println("!!! ERRO DE FORMATAÇÃO DE NÚMERO NA LINHA: " + Arrays.toString(record));
                    System.err.println("--> O erro foi: " + e.getMessage());
                    throw new RuntimeException("Falha ao processar CSV. Verifique a linha impressa acima.", e);
                }
            }
            System.out.println(">>> SUCESSO! Carga completa finalizada. " + records.size() + " Pokémon foram salvos.");

        } catch (Exception e) {
            System.err.println("!!! APLICAÇÃO FALHOU AO INICIAR. ERRO DURANTE A LEITURA DO CSV !!!");
            e.printStackTrace();
        }
    }
}