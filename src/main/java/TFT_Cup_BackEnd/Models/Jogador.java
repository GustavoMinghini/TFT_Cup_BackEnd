package TFT_Cup_BackEnd.Models;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJogador;

    @Column(nullable = false, length = 200)
    private String nick;

    @Column(nullable = true)
    private int Pontuacao;



    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idCargo) {
        this.idJogador = idJogador;
    }

    public String getnick() {
        return nick;
    }

    public void setnick(String nomeCargo) {
        this.nick = nick;
    }

    public int getPontuacao() {
        return Pontuacao;
    }

    public void setPontuacao(int salario) {
        this.Pontuacao = Pontuacao;
    }
}
