package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    private static char[][] map;
    private static final int size = 5;
    private static final int winSymb = 4;
    private static final char DOT_HUMAN = 'x';
    private static final char DOT_AI = 'o';
    private static final char DOT_EMPTY = '.';
    private static Scanner SCANNER = new Scanner(System.in);
    private static Random RANDOM = new Random();
    private static int winX, winY;
    private static int x, y;

    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void showMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void humanTurn() {
        do {
            System.out.println("Введите координаты X и Y от 1 до " + size + " через пробел:");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        map[y][x] = DOT_HUMAN;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && y >= 0 && x < size && y < size;
    }

    private static boolean isEmptyCell (int x, int y) {
        return map[y][x] == DOT_EMPTY;
    }

    // 4. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока, и пытаться выиграть сам.
    private static void aiTurn() {
        //смотрим есть ли выигрышный ход у компьютера
        if (checkWinTurn(DOT_AI) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI; //используем его
        }
        //смотрим есть ли выигрышный ход у человека
        else if (checkWinTurn(DOT_HUMAN) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI; //блокируем его своим ходом
        }
        //компьютер будет ходить рандомно в других случаях
        else {
            do {
                x = RANDOM.nextInt(size);
                y = RANDOM.nextInt(size);
            } while (!isEmptyCell(x, y));
            map[y][x] = DOT_AI;
        }
    }

    //проверка потенциальных выигрышных ходов
    private static boolean checkWinTurn(char a) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isEmptyCell(i, j)) {           //если ячейка пуста
                    map[j][i] = a;                 //временно отмечаем ход в ячейке
                    if (checkWin(a)) {
                        winX = i;                  //если этот временный ход приведет к выигрышу
                        winY = j;                  //запоминаем выигрышную комбинацию
                        map[j][i] = DOT_EMPTY;     //после очищаем ячейку поля от временного хода
                        return true;
                    }
                    map[j][i] = DOT_EMPTY;   //если выигрышной комбинации нет, просто очищаем ячейку от временного хода
                }
            }
        }
        return false;
    }

    // 2. Переделать проверку победы, чтобы она не была реализована просто набором условий.
    // в самой игре метод не используется и работает только для поля 3х3 -----------------------
    private static boolean checkWinOld(char a) {
        boolean checkHorizontal, checkVertical, checkMainDiagonal, checkSideDiagonal;
        checkMainDiagonal = true;
        checkSideDiagonal = true;
        for (int i = 0; i < size; i++) {
            if (map[i][i] != a) {
                checkMainDiagonal = false;
            }
            if (map[size-i-1][i] != a) {
                checkSideDiagonal = false;
            }
            checkHorizontal = true;
            checkVertical = true;
            for (int j = 0; j < size; j++) {
                if (map[j][i] != a) {
                    checkHorizontal = false;
                }
                if (map[i][j] != a) {
                    checkVertical = false;
                }
            }
            if (checkHorizontal || checkVertical) return true;
        }
        return checkMainDiagonal || checkSideDiagonal;
    }
    //-----------------------------------------------------------------------------------------

    /* 3. Попробовать переписать логику проверки победы, чтобы она
    работала для поля 5х5 и количества символов 4.
    (работает для любого количества символов и любого квадратного поля) */
    private static boolean checkWin(char a) {

        for (int i = 0; i <size; i++) {
            int countRow = 0;
            for (int j = 0; j < size; j++) {
                if (map[i][j] == a) {
                    countRow++;
                } else {
                    if (j + 1 < size && map[i][j + 1] != a && countRow != winSymb) {
                        countRow = 0;
                    }
                }
            }
            if (countRow >= winSymb) return true;
        }
        for (int i = 0; i <size; i++) {
            int countColumn = 0;
            for (int j = 0; j < size; j++) {
                if (map[j][i] == a) {
                    countColumn++;
                } else {
                    if (j + 1 < size && map[j + 1][i] != a && countColumn != winSymb) {
                        countColumn = 0;
                    }
                }
            }
            if (countColumn >= winSymb) return true;
        }
        for (int i = 0; i <size; i++) {
            for (int j = 0; j < size; j++) {
                int countDown = 0, countUp = 0;

                for (int k = i, l = j; k <size && l < size; k++, l++) {
                    if (map[k][l] == a) {
                        countDown++;
                    }
                    if (k + 1 < size && l + 1 < size && map[k + 1][l + 1] != a && countDown != a) return false;
                }
                for (int k = i, l = j; k <size && l < size; k--, l++) {
                    if (map[k][l] == a) {
                        countUp++;
                    }
                    if (k - 1 >= 0 && l + 1 < size && map[k - 1][l + 1] != a && countUp != a) return false;
                }
                if (countDown >= winSymb || countUp >= winSymb) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean mapIsFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    private static void start() {
        initMap();
        showMap();
        while (true) {
            humanTurn();
            showMap();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Вы выиграли!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья!");
                break;
            }
            System.out.println("Ход компьютера:");
            aiTurn();
            showMap();
            if (checkWin(DOT_AI)) {
                System.out.println("Выиграл компьютер!");
                break;
            }
            if (mapIsFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        start();
    }

}
