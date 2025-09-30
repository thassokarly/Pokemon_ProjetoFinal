package com.example.pokemon_finalProject.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_treinador")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Treinador extends Usuario {

    private int insignias;

    @Builder
    public Treinador(Integer id, String nome, String email, String senha, Integer insignias) {
        this.setId(id);
        this.setNome(nome);
        this.setEmail(email);
        this.setSenha(senha);
        this.insignias = insignias;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_TREINADOR"));
    }
    public int getInsignias() {
        return insignias;
    }
    public void setInsignias(int insignias) {
        this.insignias = insignias;
    }
}
