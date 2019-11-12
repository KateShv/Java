package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;

public class Bird extends Animal {

    public Bird(String name) {
        super(name);
        lengthRunMax = 5;
        heightJumpMax = 0.2;
    }

    @Override
    public void swim (int a) {
        System.out.println(name + " не умеет плавать!");
    }

    public void action() {
        System.out.println("Птичка украла Ваши деньги >:)");
    }
}
