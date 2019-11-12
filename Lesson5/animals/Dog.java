package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;

public class Dog extends Animal {

    public Dog(String name) {
            super(name);
            lengthRunMax = 500;
            heightJumpMax = 0.5;
            lengthSwimMax = 10;
    }

    public void speak() {
        System.out.println(name + " say Woof, woof, woof! :P");
    }

}
