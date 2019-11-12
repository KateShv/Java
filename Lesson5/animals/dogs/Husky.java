package ru.geekbrains.lesson5.animals.dogs;

import ru.geekbrains.lesson5.animals.Dog;

public class Husky extends Dog {

    public Husky(String name) {
        super(name);
        lengthRunMax = 1000;
        heightJumpMax = 1.0;
        lengthSwimMax = 50;
    }

    @Override
    public void speak() {
        System.out.println(name + " say WHOOOOOOOOO! :P");
    }

}
