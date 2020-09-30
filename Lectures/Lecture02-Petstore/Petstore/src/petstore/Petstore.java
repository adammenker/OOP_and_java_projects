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
public class Petstore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pet pet = new Pet();
        pet.setName("Maggie");
        pet.type = "Dog";
        pet.age = 3;
        pet.gender = Gender.FEMALE;
        
        Pet pet2 = new Pet("Cat", 5, "Kitty", Gender.FEMALE);
        
        System.out.println("Pet1 name = " + pet.getName());
        System.out.println("Pet2 name = " + pet2.getName());
        
        pet2.setName("Kitty2");
        
        System.out.println("Pet1 name = " + pet.getName());
        System.out.println("Pet2 name = " + pet2.getName());
        
        Dog dog = new Dog("Fido", 3, Gender.MALE);
        
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old");
        
        dog.birthday();
        
        System.out.println(dog.getName() + " is " + dog.getAge() + " years old");
        
        Dog dog2 = new Dog("Maggie", 5, Gender.FEMALE);
        
        System.out.println(dog2.getName() + " is " + dog2.getAge() + " years old");
        
        // 9/4
        
        Cat cat1 = new Cat("Susan", 2, Gender.FEMALE);
        
        System.out.println("Susans age: " + cat1.getAge());
        
        Pet pet3 = cat1; // only has pet methods and states, but cat data is hidden since its a reference to cat1 but just a different obj type
        
        System.out.println("Susans age: " + pet3.getAge());
        
        Pet pet4 = dog2;
        
        Cat cat2 = (Cat)pet3; // (Cat) cast allows that hidden cat data to be uses, so now cat2 has all data of cat1
        
        if(cat1 instanceof Cat){
            Cat cat3 = (Cat)pet3;
        }
        
        
        cat2.meow();
        
        cat2.meow(3);
        
        // start on 9/9/2020
        
        Dog dog3 = new Dog("whatever", 15, Gender.MALE);
        
        System.out.println("Dog 3: " + dog3.getName() + " ID : " + dog3.getId());
        System.out.println("NUmber of dogs Created: " + Dog.getNumOfDogs());
        
        System.out.println("NUmber of dogs Created: " + Pet.getNumOfPets());        
    }
    
}
