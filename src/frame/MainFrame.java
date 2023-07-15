package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MainFrame extends JFrame implements ActionListener {
    private JButton restartButton;
    private Button[] buttons;
    private ImageIcon[] images;
    private boolean wave;

    MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("TicTacToe");
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        buttons = new Button[9];
        this.add(displayButtons(buttons));

        images = new ImageIcon[2];
        loadImages();

        restartButton = new JButton("restart");
        this.add(displayRestartButton(), BorderLayout.NORTH);

        wave = new Random().nextBoolean();
        this.setVisible(true);
    }

    private JPanel displayButtons(Button[] button) {
        JPanel panel = new JPanel(new GridLayout(3,3));
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        for(int i = 0 ; i < button.length; i++) {
            button[i] = new Button();
            button[i].setBackground(Color.white);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black, 1));
            button[i].addActionListener(this);
            panel.add(button[i]);
        }
        return panel;
    }

    private JPanel displayRestartButton() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        restartButton.setFocusable(false);
        restartButton.addActionListener(this);
        restartButton.setBackground(Color.white);
        restartButton.setPreferredSize(new Dimension(80,20));
        panel.add(restartButton);

        return panel;
    }

    private void loadImages() {
        this.images[0] = new ImageIcon("images/circle.png");
        this.images[1] = new ImageIcon("images/square.png");
    }

    public boolean getWave() {
        return wave;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean wave = getWave();

        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (wave == true) {
                    buttons[i].setIcon(images[0]);
                    buttons[i].setValue(0);
                    this.wave = false;
                } else {
                    buttons[i].setIcon(images[1]);
                    buttons[i].setValue(1);
                    this.wave = true;
                }
                buttons[i].setEnabled(false);
            }
        }
        //restart game
        if (e.getSource() == restartButton) {
            refresh();
        }
        gameOver();
    }

    public void refresh() {
        for (Button button : buttons) {
            button.setValue(-1);
            button.setIcon(null);
            button.setEnabled(true);
        }
    }

    public void gameOver() {
        //rows
        if (buttons[0].getValue() == buttons[1].getValue() && buttons[0].getValue() == buttons[2].getValue()) {
            if (buttons[0].getValue() == 0 || buttons[0].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[0].getValue());
            }
        }
        if (buttons[3].getValue() == buttons[4].getValue() && buttons[3].getValue() == buttons[5].getValue()) {
            if (buttons[3].getValue() == 0 || buttons[3].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[3].getValue());
            }
        }
        if (buttons[6].getValue() == buttons[7].getValue() && buttons[6].getValue() == buttons[8].getValue()) {
            if (buttons[6].getValue() == 0 || buttons[6].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[6].getValue());
            }
        }
        //columns
        if (buttons[0].getValue() == buttons[3].getValue() && buttons[0].getValue() == buttons[6].getValue()) {
            if (buttons[0].getValue() == 0 || buttons[0].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[0].getValue());
            }
        }
        if (buttons[4].getValue() == buttons[1].getValue() && buttons[4].getValue() == buttons[7].getValue()) {
            if (buttons[4].getValue() == 0 || buttons[4].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[4].getValue());
            }
        }
        if (buttons[2].getValue() == buttons[5].getValue() && buttons[2].getValue() == buttons[8].getValue()) {
            if (buttons[2].getValue() == 0 || buttons[2].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[2].getValue());
            }
        }
        //diagonals
        if (buttons[0].getValue() == buttons[4].getValue() && buttons[0].getValue() == buttons[8].getValue()) {
            if (buttons[0].getValue() == 0 || buttons[0].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[0].getValue());
            }
        }
        if (buttons[2].getValue() == buttons[4].getValue() && buttons[2].getValue() == buttons[6].getValue()) {
            if (buttons[2].getValue() == 0 || buttons[2].getValue() == 1) {
                for (Button button : buttons) {
                    button.setEnabled(false);
                }
                gameOverMessage(buttons[2].getValue());
            }
        }
    }

    private void gameOverMessage(int winner) {
        if (winner == 0) {
            JOptionPane.showMessageDialog(null, "Winner: Circle", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(null, "Winner: Square", "Game Over", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}