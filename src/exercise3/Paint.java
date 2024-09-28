/**
 * @class Paint
 * @author Carl Nicolas Mendoza
 * @date 2024-09-27
 * @description Create shapes with changeable color, shape, and font size
 *
 * @example Paint.draw(5);
 */
package exercise3;

import javax.swing.*;
import java.awt.*;

public class Paint {
    // Default Values
    private static final Color color = Color.BLACK;
    private static final String shape = "circle";
    private static final int FONT_SIZE = 16;

    /**
     * Connstrutor for Paint object
     */
    public Paint() {

    }

    /**
     * @draw
     * @param size - font size
     */
    public static void draw(int size) {
        // Frame
        JFrame frame = new JFrame(shape);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(40 * size, 20 * size);
        frame.setLayout(new BorderLayout());

        // Label
        JLabel label = new JLabel("⚫");
        label.setFont(new Font("Segoe UI Symbol", Font.PLAIN, FONT_SIZE * size));
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);

        // Adding
        frame.add(label, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * @method draw
     * @param size - font size
     * @param color - font color
     */
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

    /**
     * @method draw
     * @param size - font size
     * @param color - font color
     * @param shape - text shape
     */
    public static void draw(int size, Color color, String shape) {
        // Frame
        JFrame frame = new JFrame(shape);
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
