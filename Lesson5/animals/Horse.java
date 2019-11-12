package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;

public class Horse extends Animal {

    public Horse(String name) {
        super(name);
        lengthRunMax = 1500;
        heightJumpMax = 3.0;
        lengthSwimMax = 100;
    }
}
