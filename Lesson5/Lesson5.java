package ru.geekbrains.lesson5;

import ru.geekbrains.lesson5.animals.*;
import ru.geekbrains.lesson5.animals.dogs.Husky;
import ru.geekbrains.lesson5.animals.dogs.Spitz;

public class Lesson5 {

    public static void main(String[] args) {
        Animal dog = new Dog("Guzzler");
        Animal dog1 = new Husky("Hunter");
        Animal dog2 = new Spitz("Tot");
        Animal bird = new Bird("Thief");
        Animal horse = new Horse("Rapid");
        Animal cat = new Cat("Impudent");
        Animal dolphin = new Dolphin("Tsunami");

        dog1.run(800);
        System.out.println();

        Animal[] animals = { dog, dog1, dog2, bird, horse, cat, dolphin};

        for (Animal animal : animals) {

            animal.run(550);
            animal.jump(0.5);
            animal.swim(10);

            if (animal instanceof Dog) {
                ((Dog) animal).speak();
            }

            if (animal instanceof Cat) {
                ((Cat) animal).speak();
            }

            if (animal instanceof Bird) {
                ((Bird) animal).action();
            }

            System.out.println();
        }
    }
}
