package ru.geekbrains.lesson5;

public class Animal {
    protected final String name;

    protected int lengthRunMax;
    protected double heightJumpMax;
    protected int lengthSwimMax;

    protected Animal(String name) {
        this.name = name;
    }

    public void run (int a) {
        if (a <= lengthRunMax && a > 0) {
            System.out.println(name + " пробежал!");
        } else  if (a <= 0) {
            System.out.println(name + " не сдвинулся с места, так как Вы ввели значение препятствия равное 0 или меньше. ;)");
        } else {
            System.out.println(name + " не может пробежать такую длинную дистанцию!");
        }
    }

    public void swim (int a) {
        if (a <= lengthSwimMax && a > 0) {
            System.out.println(name + " проплыл!");
        } else  if (a <= 0) {
            System.out.println(name + " не сдвинулся с места, так как Вы ввели значение препятствия равное 0 или меньше. ;)");
        } else {
            System.out.println(name + " не может проплыть такую длинную дистанцию!");
        }
    }

    public void jump (double a) {
        if (a <= heightJumpMax && a > 0) {
            System.out.println(name + " перепрыгнул!");
        } else  if (a <= 0) {
            System.out.println(name + " не сдвинулся с места, так как Вы ввели значение препятствия равное 0 или меньше. ;)");
        } else {
            System.out.println(name + " не может перепрыгнуть такое высокое препятствие!");
        }
    }

}
