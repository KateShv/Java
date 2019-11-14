package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.animals.*;

public class Lesson5 {

    public static void main(String[] args) {
        Animal dog = new Dog("Guzzler");
        Animal dog1 = new Dog("Hunter");
        Animal dog2 = new Dog("Tot");
        Animal bird = new Bird("Thief");
        Animal horse = new Horse("Rapid");
        Animal cat = new Cat("Impudent");

        dog1.run(600);
        System.out.println();

        Animal[] animals = { dog, dog1, dog2, bird, horse, cat};

        for (Animal animal : animals) {
            animal.run(550);
            animal.jump(0.5);
            animal.swim(10);
            System.out.println();
        }
    }
}
