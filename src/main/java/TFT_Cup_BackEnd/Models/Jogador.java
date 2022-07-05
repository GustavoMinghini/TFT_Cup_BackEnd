package TFT_Cup_BackEnd.Models;

import javax.persistence.Entity;

import javax.persistence.*;


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

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPontuacao() {
        return Pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        Pontuacao = pontuacao;
    }
}
