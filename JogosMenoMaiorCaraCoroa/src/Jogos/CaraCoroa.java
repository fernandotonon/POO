/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jogos;

import java.util.Scanner;

/**
 *
 * @author tonon
 */
public class CaraCoroa implements JogoInterface{

    private boolean valor = false;
    
    @Override
    public void resetar() {
        valor = false;
    }

    @Override
    public Placar jogar() {
        valor = Math.round(Math.random())%2==0;
        System.out.println("Informe seu nome");
        Scanner s1 = new Scanner(System.in);
        Placar p = new Placar(s1.nextLine());
        int numero = 0;
        while(numero<=1&&numero>=0){
            p.registrarTentativa();
            System.out.println("Informe 0 cara, 1 para coroa, outro valor para sair: ");
            Scanner s = new Scanner(System.in);
            numero = s.nextInt();
            if(numero==1&&valor||numero==0&&!valor){
                p.setGanho(true);
                return p;
            }else{
                System.out.println("Errou, tente novamente");
                valor = Math.round(Math.random())%2==0;
            }
        }
        p.setGanho(false);
        return p;
    }

    @Override
    public void abortar() {
        System.out.println("Obrigado por jogar CaraCoroa");
        System.exit(0);
    }
    
}
