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
public class MenorMaior implements JogoInterface{

    private int numeroAleatorio;
    
    public MenorMaior() {
        resetar();
    }
    
    @Override
    public void resetar() {
        numeroAleatorio = (int)(Math.random()*99+1);
    }

    @Override
    public Placar jogar() {
        int numero=1;
        System.out.println("Informe seu nome");
        Scanner s1 = new Scanner(System.in);
        Placar p = new Placar(s1.nextLine());
        while(numero>0){
            p.registrarTentativa();
            System.out.println("Informe o número, 0 para desistir: ");
            Scanner s = new Scanner(System.in);
            numero = s.nextInt();
            if(numero==numeroAleatorio){
                p.setGanho(true);
                return p;
            }else{
                System.out.println("O número informado é "+((numero>numeroAleatorio)?"MAIOR":"MENOR"));
            }
        }
        p.setGanho(false);
        return p;
    }

    @Override
    public void abortar() {
        System.exit(-1);
    }
    
}
