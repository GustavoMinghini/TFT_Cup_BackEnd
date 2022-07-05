package TFT_Cup_BackEnd.Service;

import TFT_Cup_BackEnd.Models.Jogador;
import TFT_Cup_BackEnd.Repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {
    @Autowired
    JogadorRepository jogadorRepository;

    public List<Jogador> mostrarTodosJogadores() {
        return jogadorRepository.findAll();
    }

    public Jogador mostrarJogadorPeloId(Integer idJogador){
        Optional<Jogador> jogador = jogadorRepository.findById(idJogador);
        return jogador.orElseThrow();
    }

    public Jogador cadastrarJogador(Jogador jogador) {
        jogador.setIdJogador(null);
        return jogadorRepository.save(jogador);
    }

    public void excluirJogador(Integer idJogador) {
        jogadorRepository.deleteById(idJogador);
    }

    public Jogador editarJogador(Jogador jogador) {
        Jogador jogadorProcurado = mostrarJogadorPeloId(jogador.getIdJogador());
        return jogadorRepository.save(jogador);
    }
}
