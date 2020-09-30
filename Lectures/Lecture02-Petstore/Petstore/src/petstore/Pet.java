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
public class Pet {
    // public -> access modifier
    // String -> type
    // type -> name
    // green -> global
    // states
    public String type;
    public int age;
    private String name;
    public Gender gender;
    
    private static int numOfPets = 0;
    
    
    // constructor -> same name as the class
    public Pet(){
        age = 1;
        ++numOfPets;
    }
    
    public Pet(String type, String name){
        this();
        this.type = type;
        this.name = name;
    }
    
    public Pet(String type, int age, String name, Gender gender){
        this(type, name);
        this.age = age;
        this.gender = gender;
    }
    
    public static int getNumOfPets(){
        return numOfPets;
    }
    
    // behaviors
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    
    public String getType(){
        return type;
    }
    
    public void birthday(){
        age++;
    }
    
    public int getAge(){
        return age;
    }
    
}
