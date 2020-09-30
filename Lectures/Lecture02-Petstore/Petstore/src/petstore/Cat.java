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
public class Cat extends Pet {
    public Cat(String name, int age, Gender gender){
        // instead of this.age, this.gender...
        super("Cat", age, name, gender);
    }
    
    @Override
    public int getAge(){
        if(age > 2){
            return age * 4;
        } else{ 
            return age;
        }
    }
    
    public void meow(int num){
        for(int i = 0; i < num; i++){
            System.out.println("meow.");
        }
    }
    
    public void meow(){
        meow(1);
    }
    
    public String meow(String noise){
        return noise;
    }
    
}
