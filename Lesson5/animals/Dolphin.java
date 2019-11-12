package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;

public class Dolphin extends Animal {
    public Dolphin(String name) {
        super(name);
        heightJumpMax = 5.0;
        lengthSwimMax = 5000;
    }

    @Override
    public void run (int a) {
        System.out.println(name + " не умеет ходить!");
    }

}
