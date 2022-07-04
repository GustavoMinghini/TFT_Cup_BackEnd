package TFT_Cup_BackEnd.Repository;

import TFT_Cup_BackEnd.Models.Jogador;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
    Optional<Jogador> findByEmail(String email);

}
