package TFT_Cup_BackEnd.Service;

import TFT_Cup_BackEnd.Models.Jogador;
import TFT_Cup_BackEnd.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class JogadorService {
    @Autowired
    JogadorRepository jogadorRepository;

    public List<Jogador> mostrarTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador mostrarJogadorPeloId(Integer idJogador){
        Optional<Jogador> Jogador = jogadorRepository.findById(idJogador);
        return Jogador.orElseThrow();
    }


    public Jogador cadastrarJogador(Jogador Jogador) {
        Jogador.setIdJogador(null);
        return jogadorRepository.save(Jogador);
    }

    public void excluirJogador(Integer idJogador) {
        jogadorRepository.deleteById(idJogador);
    }

    public Jogador editarJogador(Jogador Jogador) {
        return jogadorRepository.save(Jogador);
    }
}
