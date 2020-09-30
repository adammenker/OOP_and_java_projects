/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amdy6helloworldf20;

/**
 *
 * @author adammenker
 */
public class Amdy6HelloWorldF20 {

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {

        Amdy6HelloWorldF20 myObj = new Amdy6HelloWorldF20();
        myObj.invokeMe();
    }
 
    public void invokeMe(){   	
    	System.out.println("Hello World!");
        
        PawPrint myPawprintObject = new PawPrint();
        myPawprintObject.printPawPrint("amdy6");
     
        MyCurrentDate todaysDate = new MyCurrentDate();
        todaysDate.printDate();
    }
}
