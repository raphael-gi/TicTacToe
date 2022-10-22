import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Game implements ActionListener {
    JButton[] buts;
    JButton[][] grid;
    JButton reset;
    JLabel message;
    JLabel playmessage;
    private final String end = "Game has ended";

    private JButton[] winners;
    private boolean turn = true;

    public Game() {
        Frame frame = new Frame();
        this.buts = frame.buts;
        this.grid = frame.grid;
        this.reset = frame.reset;
        this.message = frame.message;
        this.playmessage = frame.playmessage;

        for (int i = 0; i < 9; i++) {
            this.buts[i].addActionListener(this);
        }
        this.reset.addActionListener(this);
    }

    public void check() {
        int filled = 0;
        for (int i = 0; i < 9; i++) {
            JButton but = buts[i];
            if (!but.getText().isEmpty()) {
                filled++;
            }
        }
        if (filled > 8) {
            draw();
        }
        for (int i = 0; i < 8; i++) {
            JButton[] item = grid[i];
            ArrayList<String> checks = new ArrayList<>();
            for (int b = 0; b < 3; b++) {
                if (!item[b].getText().isEmpty()) {
                    checks.add(item[b].getText());
                }
            }
            if (checks.size() > 2) {
                if (checks.get(0).equals(checks.get(1)) && checks.get(0).equals(checks.get(2))) {
                    winner(checks.get(0).equals("X"), item);
                }
            }
        }
    }

    public void winner(boolean win, JButton[] winners) {
        for (int i = 0; i < 3; i++) {
            winners[i].setBackground(Color.GREEN);
            this.winners = winners;
        }
        if (win) {
            message.setText("THE WINNER IS X!");
        }
        else {
            message.setText("THE WINNER IS O!");
        }
        playmessage.setText(end);
        reset.setVisible(true);
        for (int i = 0; i < 9; i++) {
            buts[i].setEnabled(false);
        }
    }

    public void draw() {
        message.setText("IT'S A DRAW!");
        playmessage.setText(end);
        reset.setVisible(true);
        for (int i = 0; i < 9; i++) {
            buts[i].setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String p1 = "X, it's your turn";
        for (int i = 0; i < 9; i++) {
            JButton but = buts[i];
            if (e.getSource() == but) {
                if (but.getText().isEmpty()) {
                    if (turn) {
                        but.setText("X");
                        turn = false;
                        playmessage.setText("O, it's your turn");
                    }
                    else {
                        but.setText("O");
                        turn = true;
                        playmessage.setText(p1);
                    }
                    check();
                }
            }
        }
        if (e.getSource() == reset) {
            reset.setVisible(false);
            message.setText("Let's play a game!");

            for (int i = 0; i < 9; i++) {
                buts[i].setEnabled(true);
                buts[i].setText("");
                turn = true;
                playmessage.setText(p1);
            }
            if (winners == null) return;
            for (int i = 0; i < 3; i++) {
                winners[i].setBackground(null);
            }
        }
    }
}