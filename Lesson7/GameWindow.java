package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {

    private static final int WIN_WIDTH = 507;
    private static final int WIN_HEIGHT = 555;
    private static final int WIN_POSX = 650;
    private static final int WIN_POSY = 250;

    private GameMap map;
    private Settings settings;

    GameWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setBounds(WIN_POSX, WIN_POSY, WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);

        JButton btnStart = new JButton("Start");
        JButton btnExit = new JButton("<html><body><b>Exit</b></body></html>");
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));
        panelBottom.add(btnStart);
        panelBottom.add(btnExit);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        map = new GameMap();
        settings = new Settings(this);

        add(map, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        map.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}

