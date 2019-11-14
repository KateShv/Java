package ru.geekbrains.lesson5.animals;

import ru.geekbrains.lesson5.Animal;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        lengthRunMax = 200;
        heightJumpMax = 2.0;
    }

    @Override
    public void swim (int a) {
        System.out.println(name + " не умеет плавать!");
    }

    public void speak() {
        System.out.println(name + " say Meoooooooow!");
    }

}
