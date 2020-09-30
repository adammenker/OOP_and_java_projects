/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6languagebasicsf20;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author adammenker
 */
public class Amdy6LanguageBasicsF20 {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
//        // TODO code application logic here

        LanguageBasicsStatesAndBehaviors javaLangBasics;
        javaLangBasics = new LanguageBasicsStatesAndBehaviors('a', (char)97, (short)89, 12, 1023.5f, 365f, true, false, "Hello", "amdy6");
        
        javaLangBasics.oututMethods();
    }
}

