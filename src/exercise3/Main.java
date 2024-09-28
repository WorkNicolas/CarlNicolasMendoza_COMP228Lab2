/**
 * @class Main
 * @author Carl Nicolas Mendoza
 * @date 2024-09-27
 * @description Runs Paint
 *
 */
package exercise3;

import java.awt.Color;

public class Main {
    public static void main (String[] args) {
        Paint.draw(5);
        Paint.draw(15, Color.RED);
        Paint.draw(20, Color.PINK, "cross");
    }
}
