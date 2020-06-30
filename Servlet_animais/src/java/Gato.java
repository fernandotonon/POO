/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class Gato extends Animal{

    public Gato() {
        super(4, false, false);
    }
    
    @Override
    public String emitirSom() {
        return "Miau!";
    }
    
}
