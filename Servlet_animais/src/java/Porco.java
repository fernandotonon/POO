/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tonon
 */
public class Porco extends Animal{
    
    public Porco() {
        super(4, false, true);
    }
    
    @Override
    public String emitirSom() {
        return "Oinc oinc!";
    }

    @Override
    public String receitaPreparo() {
        return "<ol>\n" +
"	<li>Em um vasilha com tampa coloque todos os ingredientes.</li>\n" +
"	<li>Misture bem e feche.</li>\n" +
"	<li>Deixe na geladeira por 2 horas.</li>\n" +
"	<li>Em seguida coloque em uma panela.</li>\n" +
"	<li>Deixe refogar, cubra com água, tampe e deixe cozinhar até secar e começar a fritar novamente,</li>\n" +
"	<li>Bom Apetite.</li>\n" +
"</ol>";
    }
    
}
