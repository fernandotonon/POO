/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class Pato extends Animal{
    
    public Pato() {
        super(2, true, true);
    }
    
    @Override
    public String emitirSom() {
        return "Quack Quack!";
    }

    @Override
    public String receitaPreparo() {
        return "<ol class=\"content-ordered-list theme-ordered-list-color-primary\"><li itemprop=\"recipeInstructions\">Tempere o pato com o alho, sal pimenta, suco de limão, o vinho e deixe descansar 6 horas</li><li itemprop=\"recipeInstructions\">Retire o pato do tempero e escorra bem.</li><li itemprop=\"recipeInstructions\">Unte com a manteiga,</li><li itemprop=\"recipeInstructions\">Coloque o pato numa assadeira com o tempero</li><li itemprop=\"recipeInstructions\">Leve ao forno</li><li itemprop=\"recipeInstructions\">Depois de 20 minutos comece a regar com o suco de laranja.</li><li itemprop=\"recipeInstructions\">Deixe mais 30 minutos</li><li itemprop=\"recipeInstructions\">Quando o pato estiver assado, retire do forno,coloque numa travessa regue com o molho que ficou na assadeira</li><li itemprop=\"recipeInstructions\">Decore com gomos de laranja e sirva</li></ol>";
    }
    
    
}
