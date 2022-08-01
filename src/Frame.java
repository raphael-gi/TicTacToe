import javax.swing.*;
import java.awt.*;

public class Frame {
    private final JButton but1 = new JButton();
    private final JButton but2 = new JButton();
    private final JButton but3 = new JButton();
    private final JButton but4 = new JButton();
    private final JButton but5 = new JButton();
    private final JButton but6 = new JButton();
    private final JButton but7 = new JButton();
    private final JButton but8 = new JButton();
    private final JButton but9 = new JButton();
    JButton[] buts = new JButton[]{but1, but2, but3, but4, but5, but6, but7, but8, but9};
    JButton[][] grid = new JButton[][] {{but1, but2, but3}, {but4, but5, but6}, {but7, but8, but9}, {but1, but4, but7}, {but2, but5, but8}, {but3, but6, but9}, {but1, but5, but9}, {but3, but5, but7}};
    JButton reset = new JButton("Restart Game");
    JLabel message = new JLabel("Let's play a game!");
    JLabel playmessage = new JLabel("Player 1, it's your turn");

    public Frame() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        panel.setLayout(new GridLayout(4, 3, 8, 8));
        frame.add(panel);
        for (int i = 0; i < 9; i++) {
            panel.add(buts[i]);
        }
        panel.add(playmessage);
        panel.add(message);
        panel.add(reset);
        reset.setVisible(false);
    }
}