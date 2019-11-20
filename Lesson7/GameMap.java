package Lesson7;

import javax.swing.*;
import java.awt.*;

public class GameMap extends JPanel {
    public static final int GM_HVH = 0;
    public static final int GM_HVA = 1;
    public static final char DOT_EMPTY = '.';

    int mode;
    int winLength;

    char[][] map;
    int fieldSizeX;
    int fieldSizeY;

    int cellHeight;
    int cellWidth;

    boolean isInitialized = false;

    GameMap() {
        setBackground(Color.GRAY);
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g){

        if (!isInitialized) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeigth = getHeight();

        cellHeight = panelHeigth / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);
        }
    }

    /*
    пока не знаю как к этому потом прикрутить отрисованные ячейки
    и проверять в них метки

    void initMap(int x, int y) {
        map = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    */


    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        this.mode = mode;
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;

        /*для просто отрисовки не надо, но нужно будет для старта
        initMap(fieldSizeX, fieldSizeY);
        */

        isInitialized = true;
        repaint();

    }
}