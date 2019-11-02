package ru.geekbrains.lesson2;

import java.util.Arrays;

public class Lesson2 {

    /* 1) Задать целочисленный массив, состоящий из элементов 0 и 1.
       Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
       Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0 */
    private static void arrayInvert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
        }
    }

    /* 2) Задать пустой целочисленный массив размером 8.
    Написать метод, который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22; */
    private static void arrayPush(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3 + 1;
        }
    }


    /* 3) Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
    написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2*/
    private static void arrayChange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        }
    }

    /* 4) Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента */
    private static int arrayMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = (min <= arr[i]) ? min : arr[i];
        }
        return min;
    }

    private static int arrayMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = (max >= arr[i]) ? max : arr[i];
        }
        return max;
    }

    /* 5) Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
    заполнить его диагональные элементы единицами, используя цикл(ы) */
    private static void arrayDiagon(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int x = 0, y = arr[i].length; x < arr[i].length; x++, y--) {
                if (i == x || i == (y - 1)) arr[i][x] = 1;
            }
        }
    }

    /* 6) Написать метод, в который передается не пустой одномерный целочисленный массив,
    метод должен вернуть true если в массиве есть место, в котором сумма левой и
    правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
    checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
    Абстрактная граница показана символами ||, эти символы в массив не входят.*/
    private static boolean arrayBalance(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int x = 0; x < i; x++) {
                leftSum += arr[x];
            }
            for (int y = i; y < arr.length; y++) {
                rightSum += arr[y];
            }
            if (leftSum == rightSum) return true;
        }
        return false;
    }

    /* 7) Написать метод, которому на вход подаётся одномерный массив и число n
    (может быть положительным, или отрицательным), при этом метод должен циклически
    сместить все элементы массива на n позиций.
    8) Не пользоваться вспомогательным массивом при решении задачи 7. */
    private static int[] arrayShift(int[] arr, int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                for (int x = arr.length - 1; x >= 0; x--) {
                    int current = arr[x];
                    int shift = (x - 1 < 0) ? 0 : x - 1;
                    arr[x] = arr[shift];
                    arr[shift] = current;
                }
            }
            return arr;
        } else {
            for (int i = 0; i < n*(-1); i++) {
                for (int y = 0; y < arr.length - 1; y++) {
                    int current = arr[y];
                    int shift = (y + 1 > arr.length - 1) ? 0 : y + 1;
                    arr[y] = arr[shift];
                    arr[shift] = current;
                }
            }
            return arr;
        }
    }


    public static void main (String[] args) {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        arrayInvert(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int[8];
        arrayPush(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        arrayChange(arr3);
        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {48, 155, 30, 12, 11, 4, 57, 22, 64, 8, 19, 92};
        System.out.println(arrayMin(arr4));
        System.out.println(arrayMax(arr4));

        int[][] arr5 = new int[5][5];
        arrayDiagon(arr5);
        for (int[] ints : arr5) {
            System.out.println(Arrays.toString(ints));
        }

        int[] arr6 = {1, 2, 3, 2, 4};
        System.out.println(arrayBalance(arr6));

        int[] arr7 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        arrayShift(arr7, 3);
        System.out.println(Arrays.toString(arr7));

    }

}