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
    public List<Jogador> mostrarTodosClientes() {
        List<Jogador> clientes = jogadorService.mostrarTodosJogadores();
        return clientes;
    }

    @GetMapping("/jogador/{idJogador}")
    public ResponseEntity<Jogador> mostrarClientePeloId(@PathVariable Integer idCliente) {
        Jogador cliente = jogadorService.mostrarJogadorPeloId(idCliente);
        return ResponseEntity.ok().body(cliente);
    }


    @PostMapping("/jogador")
    public ResponseEntity<Jogador> cadastrarCliente(@RequestBody Jogador cliente) {
        cliente = jogadorService.cadastrarJogador(cliente);
        URI novaUri = ServletUriComponentsBuilder.fromCurrentRequest().path("id")
                .buildAndExpand(cliente.getIdJogador()).toUri();
        return ResponseEntity.created(novaUri).body(cliente);
    }

    @DeleteMapping("jogador/{idJogador}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Integer idCliente) {
        jogadorService.excluirJogador(idCliente);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("jogador/{idJogador}")
    public ResponseEntity<Jogador> editarCliente(@PathVariable Integer idCliente,
                                                 @RequestBody Jogador cliente) {
        cliente.setIdJogador(idCliente);
        jogadorService.editarJogador(cliente);
        return ResponseEntity.ok().body(cliente);
    }
}
