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
public class Jogos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Placar placar;
        JogoInterface jogo;
        
        while(true){
            System.out.println("Escolha o jogo: \n 0 - MaiorMenor \n 1 - CaraCoroa");
            Scanner s = new Scanner(System.in);
            int numero = s.nextInt();
            switch(numero){
                case 0:
                    jogo=new MenorMaior();
                    break;
                case 1:
                    jogo=new CaraCoroa();
                    break;
                default:
                    jogo=new MenorMaior();
            }

            placar = jogo.jogar();

            System.out.println(placar.getStr());
            
            System.out.println("Continuar jogando? s/n");
            if(s.next().equals("n"))
                jogo.abortar();
        }
    }
    
}
