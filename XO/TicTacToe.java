package XO;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static char[][] map;
    private static final int size = 5;
    private static final int winSymb = 4;
    private static final int aiSmartWinSybols = 3;
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
            System.out.printf("Введите координаты X и Y от 1 до %d через пробел:\n", size);
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
        //смотрим есть ли финальный выигрышный ход у компьютера
        if (checkWinTurn(DOT_AI, winSymb) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI; //используем его
        }
        //смотрим есть ли финальный выигрышный ход у человека
        else if (checkWinTurn(DOT_HUMAN, winSymb) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI; //блокируем его своим ходом
        }
        //если нет финальных выигрышных ходов то компьютер ходит по умному
        else if (checkWinTurn(DOT_HUMAN, aiSmartWinSybols) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI;
        } else if (checkWinTurn(DOT_AI, aiSmartWinSybols) && isEmptyCell(winX, winY) && isValidCell(winX, winY)) {
            map[winY][winX] = DOT_AI;
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
    //работает и для смарт ходов компьютера для блокирования возможных вилок
    private static boolean checkWinTurn(char dot, int symbolsToWin) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isEmptyCell(i, j)) {           //если ячейка пуста
                    map[j][i] = dot;                 //временно отмечаем ход в ячейке
                    if (checkWin(dot, symbolsToWin)) {
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

    // проверка победы по 4 направлениям
    private static boolean checkWin(char dot, int symbolsToWin) {
        for (int i = 0; i < size; i++) {          // ползём по всему полю
            for (int j = 0; j < size; j++) {
                if (checkWinLine(i, j, 1, 0, dot, symbolsToWin)) {
                    return true;
                }
                if (checkWinLine(i, j, 1, 1, dot, symbolsToWin)) {
                    return true;
                }
                if (checkWinLine(i, j, 0, 1, dot, symbolsToWin)) {
                    return true;
                }
                if (checkWinLine(i, j, 1, -1, dot, symbolsToWin)) {
                    return true;
                }
            }
        }
        return false;
    }

    //проверка количества дотов по линиям в любом направлении, смотря какое задали для х и у в чеквин
    //формула из алгебры для вычисления длины линии от заданной начальной точки
    private static boolean checkWinLine(int x, int y, int directionX, int directionY, char dot, int lengthLineDot) {
        int lengthX = x + (lengthLineDot - 1) * directionX, lengthY = y + (lengthLineDot - 1) * directionY;
        if (!isValidCell(lengthX, lengthY)) {
            return false;
        }
        for (int i = 0; i < lengthLineDot; i++) {
            if (map[y + i * directionY][x + i * directionX] != dot) {
                return false;
            }
        }
        return true;
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
            if (checkWin(DOT_HUMAN, winSymb)) {
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
            if (checkWin(DOT_AI, winSymb)) {
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
