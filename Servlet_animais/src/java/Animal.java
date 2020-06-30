
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public abstract class Animal implements Serializable{
    private int qtdPatas;
    private boolean voa;
    private boolean comestivelOcidente;
    private String nome;
    private String raca;

    public Animal(int qtdPatas, boolean voa, boolean comestivelOcidente, String nome, String raca) {
        this.qtdPatas = qtdPatas;
        this.voa = voa;
        this.comestivelOcidente = comestivelOcidente;
        this.nome = nome;
        this.raca = raca;
    }
    
    protected Animal(int qtdPatas, boolean voa, boolean comestivelOcidente) {
        this(qtdPatas,voa,comestivelOcidente,"Sem nome","SRD");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
    

    public int getQtdPatas() {
        return qtdPatas;
    }

    public void setQtdPatas(int qtdPatas) {
        this.qtdPatas = qtdPatas;
    }

    public boolean isVoa() {
        return voa;
    }

    public void setVoa(boolean voa) {
        this.voa = voa;
    }

    public boolean isComestivelOcidente() {
        return comestivelOcidente;
    }

    public void setComestivelOcidente(boolean comestivelOcidente) {
        this.comestivelOcidente = comestivelOcidente;
    }
    
    public abstract String emitirSom();
    
    public String receitaPreparo(){
        return "";
    }
}
