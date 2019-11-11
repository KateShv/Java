package ru.geekbrains.lesson1;

public class Main {

    public static void main(String[] args) {
	// вызовы методов для проверки

        float result = arith(5, 7, 20, 7);
        System.out.println(result);

        boolean sravn = sravnSum(5, 7);
        System.out.println(sravn);

        alert(-5);

        Hello("Kate");

        Year(2019);
    }


    /* Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат с
     * плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода; */

    private static float arith(int a, int b, int c, int d) {

        float math =  (float) a * ((float) b + ((float) c / (float) d));
        return(math);
    }


    /* Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит
     * в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false; */

    private static boolean sravnSum(int a, int b) {

        boolean res1 = true;
        boolean res2 = false;
        int sum = a + b;

        if (sum >= 10 && sum <= 20)
            return (res1);
        else
            return (res2);
    }


/* Написать метод, которому в качестве параметра передается целое число, метод должен
 * проверить положительное ли число передали, или отрицательное.
 * Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль */

    private static void alert(int a) {

        if (a >= 0)
            System.out.println(a + " Положительное число");
        else
            System.out.println(a + " Отрицательное число");
    }


/* Написать метод, которому в качестве параметра передается строка, обозначающая имя,
 * метод должен вернуть приветственное сообщение «Привет, переданное_имя!»; Вывести
 * приветствие в консоль. */

    private static String Hello(String a){

        String b = "Привет, " + a + "!";
        System.out.println(b);
        return (b);
    }


/* Написать метод, который определяет является ли год високосным. Каждый 4-й год
 * является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 * Для проверки работы вывести результаты работы метода в консоль */

    private static void Year(int a) {

        if ((a % 100 == 0 && a % 400 == 0) || (a % 4 == 0 && a % 100 > 0) )
            System.out.println(a + " Год високосный");
        else
            System.out.println(a + " Год не високосный");
    }

}
