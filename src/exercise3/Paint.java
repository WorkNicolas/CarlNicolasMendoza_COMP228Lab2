package exercise3;

import javax.swing.*;
import java.awt.*;

public class Paint {
    private int size = 1;
    private String color = "black";
    private String shape = "circle";
    private static final int FONT_SIZE = 16;
    public Paint() {

    }
    public static void draw(int size) {
        // Frame
        JFrame frame = new JFrame("Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(40 * size, 20 * size);
        frame.setLayout(new BorderLayout());

        // Label
        JLabel label = new JLabel("⚫");
        label.setFont(new Font("Segoe UI Symbol", Font.PLAIN, FONT_SIZE * size));
        label.setForeground(Color.BLACK);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Adding
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void draw(int size, Color color) {
        // Frame
        JFrame frame = new JFrame("Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(40 * size, 20 * size);
        frame.setLayout(new BorderLayout());

        // Label
        JLabel label = new JLabel("⚫", JLabel.CENTER);
        label.setFont(new Font("Segoe UI Symbol", Font.PLAIN, FONT_SIZE * size));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Adding
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void draw(int size, Color color, String shape) {
        // Frame
        JFrame frame = new JFrame("Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(40 * size, 20 * size);
        frame.setLayout(new BorderLayout());

        // Shapes
        switch (shape.toLowerCase()) {
            case "rectangle":
                shape = "▬";
                break;
            case "parallelogram":
                shape = "▰";
                break;
            case "triangle":
                shape = "▲";
                break;
            case "diamond":
                shape = "◆";
                break;
            case "square":
                shape = "⬛";
                break;
            case "pentagon":
                shape = "⬟";
                break;
            case "octagon":
                shape = "⬢";
                break;
            case "oval":
                shape = "⬬";
                break;
            case "semicircle":
                shape = "⯊";
                break;
            case "cross":
                shape = "\uD83D\uDFA7";
                break;
            default:
                shape = "⚫";
                break;
        }

        // Label
        JLabel label = new JLabel(shape, JLabel.CENTER);
        label.setFont(new Font("Segoe UI Symbol", Font.PLAIN, FONT_SIZE * size));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Adding
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
