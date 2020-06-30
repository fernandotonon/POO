/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class Crianca extends Pessoa{

    @Override
    public void setNome(String nome) {
        if(nome.equals("joãozinho"))
            nome = "criança";
        super.setNome(nome); //To change body of generated methods, choose Tools | Templates.
        System.out.println(nome);
    }
    
}
