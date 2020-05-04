/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogos;

/**
 *
 * @author tonon
 */
public class Placar {
    private String str;
    private boolean ganho;
    private int tentativas = 0;

    public Placar(String str) {
        this.str = str;
    }

    public String getStr() {
        return str+" "+(ganho?"ganhou":"perdeu")+" após "+ tentativas+ " tentativas.";
    }
    

    public boolean isGanho() {
        return ganho;
    }

    public void setGanho(boolean ganho) {
        this.ganho = ganho;
    }    

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }
    
    public void registrarTentativa() {
        this.tentativas++;
    }
}
