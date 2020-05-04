/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aulaheranca;

/**
 *
 * @author tonon
 */
public class AulaHeranca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Cavalo cavalo = new Cavalo();
        Preguica preguica = new Preguica();

        Veterinario vet = new Veterinario();
        vet.examinar(cachorro);
        vet.examinar(cavalo);
        vet.examinar(preguica);

        Zoo z = new Zoo();
        for(Animal a : z.jaula){
            a.emitirSom();
            if(a instanceof Cachorro){
                    ((Cachorro)a).correr();
                }
            else if(a instanceof Cavalo){
                    ((Cavalo)a).correr();
                }
        }
    }

}
