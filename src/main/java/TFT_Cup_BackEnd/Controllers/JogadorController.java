package TFT_Cup_BackEnd.Controllers;


import TFT_Cup_BackEnd.Models.Jogador;
import TFT_Cup_BackEnd.Service.JogadorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("servicos")
public class JogadorController {
    @Autowired
    JogadorService jogadorService;

    @GetMapping("/jogador")
    public List<Jogador> mostrarTodosJogadores  () {
        List<Jogador> jogador = jogadorService.mostrarTodosJogadores();
        return jogador;
    }

    @GetMapping("/jogador/{idJogador}")
    public ResponseEntity<Jogador> mostrarClientePeloId(@PathVariable Integer idJogador) {
        Jogador jogador = jogadorService.mostrarJogadorPeloId(idJogador);
        return ResponseEntity.ok().body(jogador);
    }

    @PostMapping("/jogador")
    public ResponseEntity<Jogador> cadastrarJogador(@RequestBody Jogador jogador) {
        jogador = jogadorService.cadastrarJogador(jogador);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(jogador.getIdJogador()).toUri();
        return ResponseEntity.created(novaUri).body(jogador);
    }

    @DeleteMapping("jogador/{idJogador}")
    public ResponseEntity<Void> excluirJogador(@PathVariable Integer idJogador) {
        jogadorService.excluirJogador(idJogador);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("jogador/{idJogador}")
    public ResponseEntity<Jogador> editarJogador(@PathVariable Integer idJogador,
                                                 @RequestBody Jogador jogador) {
        jogador.setIdJogador(idJogador);
        jogadorService.editarJogador(jogador);
        return ResponseEntity.ok().body(jogador);
    }
}
