package fruit;

import animal.Dog;

public class Banana {
    public static void main(String[] args) {
        // because Apple.java and Banana.java are under same package
        Apple apple = new Apple();


        // because Dog.java is public class,
        // which can be referenced by the class in another package
        Dog dog = new Dog();
    
    
        Lemon lemon = new Lemon();
        lemon.name = "same package, protected still can read";
    

    }
}
