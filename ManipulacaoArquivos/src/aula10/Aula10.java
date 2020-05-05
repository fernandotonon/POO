/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tonon
 */
public class Aula10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        try {
            Path uri = Paths.get("arquivo.txt");
            if(Files.exists(uri))
            {
                    System.out.printf("Tamanho: %s%n", Files.size(uri));
                    System.out.printf("Data da Última Modificação: %s%n", Files.getLastModifiedTime(uri));
                    System.out.printf("Tamanho: %s%n", uri.toAbsolutePath());
            }
            else
            {
                System.out.println("URI não existe");
            }
        } catch (IOException ex) {
                Logger.getLogger(Aula10.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
