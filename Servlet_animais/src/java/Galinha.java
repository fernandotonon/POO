/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class Galinha extends Animal{

    public Galinha(){
        super(2,true,true);
    }
    
    @Override
    public String emitirSom() {
        return "Có có có";
    }

    @Override
    public String receitaPreparo() {
        return "<ol><li><span tabindex=\"0\"><p>Coloque a água em uma panela e derreta os cubinhos de caldo de galinha.</p></span></li><li><span tabindex=\"0\"><p>Acrescente o molho de tomate e o frango, mexa até começar a ferver.</p></span></li><li><span tabindex=\"0\"><p>Coloque a farinha de trigo e mexa até engrossar.</p></span></li><li><span tabindex=\"0\"><p>Acrescente <a href=\"https://blog.tudogostoso.com.br/cardapios/receitas-de-bolos-e-doces/creme-de-leite-fresco-como-fazer/\" target=\"_blank\" rel=\"noopener\">o creme de leite</a>, misture bem.</p></span></li><li><span tabindex=\"0\"><p>Despeje tudo em uma travessa e espalhe por cima a manteiga e o queijo ralado.</p></span></li><li><span tabindex=\"0\"><p>Leve ao forno para gratinar por mais ou menos 20 minutos.</p></span></li></ol>";
    }
    
    
    
}
