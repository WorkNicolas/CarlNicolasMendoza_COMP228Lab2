package exercise2;


import javax.swing.JOptionPane;

public class Lotto {
    private int[] numbers = new int[3];
    public Lotto() {
        this.numbers = lottoRandomizer(this.numbers);
        int number = this.userInput();
        this.roll(number);
    }
    // Setters
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    // Getters
    public int[] getNumbers() {
        return numbers;
    }

    // Methods
    public int userInput() {
        int number = 0;
        try {
            do {
                String numberString = JOptionPane.showInputDialog(null,
                        "Choose a number from 3 to 27:",
                        "Pick a number.",
                        JOptionPane.QUESTION_MESSAGE
                );
                number = Integer.parseInt(numberString);
            } while (!(number >= 3 && number <= 27));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "Please type a valid number.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
            );
            userInput();
        }
        return number;
    }
    public void roll(int number) {
        int lottoSum = arraySum(this.numbers);
        this.arraySum(numbers);
        int itr = 0;
        do {
            JOptionPane.showMessageDialog(
                    null,
                    "Current Sum: " + lottoSum + "\nRoll: " + itr,
                    "User Input: " + number,
                    JOptionPane.INFORMATION_MESSAGE
            );
            lottoSum = arraySum(lottoRandomizer(this.numbers));
            itr++;
        } while (number != lottoSum && itr < 5);
        if (number != lottoSum) {
            JOptionPane.showMessageDialog(
                    null,
                    "You lost!",
                    "Current Number: " + lottoSum,
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "You won!",
                    "Current Number: " + lottoSum,
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }
    public int arraySum(int[] numbers) {
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number += numbers[i];
        }
        return number;
    }
    public int[] lottoRandomizer(int[] numbers) {
        int[] array = new int[numbers.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 9);
        }
        return array;
    }
}
