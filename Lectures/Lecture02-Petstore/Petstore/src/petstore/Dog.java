/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author adammenker
 */
public class Dog extends Pet {
    
    private int id;
    
    private static int numOfDogs = 0;
    
    private static final String GENUS = "Canis";
    
    public Dog(String name, int age, Gender gender){
        super("Dog", age, name, gender);
//        super.age = 3;
//        super.birthday(); 

        id = ++numOfDogs;
    }
    
    public int getId(){
        return this.id;
    }
    
    public static int getNumOfDogs(){
        return numOfDogs;
    }
    
    public static String getGenus(){
        return GENUS;
    }
    
    @Override
    public int getAge(){
        return age * 7;
    }
    
    public void bark(int num){
        for(int i = 0; i < num; i++){
            System.out.println("Bark!");
        }
    }
    
    public void bark(){
        bark(1);
    }
}
