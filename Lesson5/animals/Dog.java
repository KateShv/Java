package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;
import java.util.Random;

public class Dog extends Animal {

    private double run;

    public Dog () {
        Random random = new Random();
        run = random.nextDouble() * (800.01 - 1.0) + 400.0;
    }

    public Dog(String name) {
        super(name);
        this ();
        lengthRunMax = run;
        heightJumpMax = 0.5;
        lengthSwimMax = 10;
    }

}
