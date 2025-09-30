package com.example.pokemon_finalProject.service;
import com.example.pokemon_finalProject.dto.AuthRequest;
import com.example.pokemon_finalProject.dto.ProfessorDTO;
import com.example.pokemon_finalProject.dto.TreinadorDTO;
import com.example.pokemon_finalProject.exception.EmailAlreadyExistsException;
import com.example.pokemon_finalProject.model.Professor;
import com.example.pokemon_finalProject.model.Treinador;
import com.example.pokemon_finalProject.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public Map<String, String> registerProfessor(ProfessorDTO request) {
        usuarioRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new EmailAlreadyExistsException("O email '" + request.getEmail() + "' já está em uso.");
        });
        var professor = Professor.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .especialidade(request.getEspecialidade())
                .build();

        usuarioRepository.save(professor);
        var jwtToken = jwtUtil.generateToken(professor);
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        return response;
    }
    public Map<String, String> registerTreinador(TreinadorDTO request) {
        usuarioRepository.findByEmail(request.getEmail()).ifPresent(user -> {
            throw new EmailAlreadyExistsException("O email '" + request.getEmail() + "' já está em uso.");
        });
        var treinador = Treinador.builder()
                .nome(request.getNome())
                .email(request.getEmail())
                .senha(passwordEncoder.encode(request.getSenha()))
                .insignias(request.getInsignias())
                .build();
        usuarioRepository.save(treinador);
        var jwtToken = jwtUtil.generateToken(treinador);
        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        return response;
    }
    public Map<String, String> authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getSenha())
        );
        var usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o email: " + request.getEmail()));
        var jwtToken = jwtUtil.generateToken(usuario);

        Map<String, String> response = new HashMap<>();
        response.put("token", jwtToken);
        return response;
    }
}

