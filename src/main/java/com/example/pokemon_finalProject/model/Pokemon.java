package com.example.pokemon_finalProject.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pokedex_number")
    private Integer numeroPokedex;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo_1", nullable = false)
    private String tipo1;

    @Column(name = "tipo_2")
    private String tipo2;

    @Column(name = "vida", nullable = false)
    private int hp;

    @Column(name = "ataque", nullable = false)
    private int ataque;

    @Column(name = "defesa", nullable = false)
    private int defesa;

    @Column(name = "especial", nullable = false)
    private int especial;

    @Column(name = "velocidade", nullable = false)
    private int velocidade;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor criadoPor;

    public String getTipo2() {
        if (this.tipo2 == null || this.tipo2.trim().isEmpty() || this.tipo2.equalsIgnoreCase("None")) {
            return "None";
        }
        return this.tipo2;
    }
}
