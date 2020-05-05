/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonon
 */
public class ManipulaArquivo {
    public static void main(String[] args) {
        Formatter arquivoEscrita;
        try {
            arquivoEscrita = new Formatter("arquivo.txt");        
            arquivoEscrita.format("%s %d %n", "teste", 1);
            arquivoEscrita.close();
            
            Scanner arquivoLeitura = new Scanner(Paths.get("arquivo.txt"));
            while(arquivoLeitura.hasNext()){
                System.out.printf("%s %d %n", arquivoLeitura.next(), arquivoLeitura.nextInt());
            }
            arquivoLeitura.close();
        } catch (Exception ex) {            
        }
    }
}
