package exercise1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Test {
    public Test() {
        this.inputAnswer();
    }
    public static String[] shuffleStringArray(String[] array) {
        List<String> list = new ArrayList<>(Arrays.asList(array));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }
    private Map<String[], JComboBox> simulateQuestion() {
        Map<String[], JComboBox> qna = new HashMap<>(); // Questions and Answers
        int numberOfQuestions = 5;
        String[][] questions = new String[numberOfQuestions][2];
        String[][] choices = new String[numberOfQuestions][4];
        JComboBox[] comboBox = new JComboBox[numberOfQuestions];

        // Question 1
        questions[0] = new String[] {
                "What database object are SELECT queries stored in?",
                "Views"
        };
        choices[0] = new String[] {
                "Views",
                "Subquery",
                "Synonym",
                "DDL"
        };
        comboBox[0] = new JComboBox(shuffleStringArray(choices[0]));
        qna.put(questions[0], comboBox[0]);

        // Question 2
        questions[1] = new String[] {
                "What database object are snapshots stored in?",
                "Materialized Views"
        };
        choices[1] = new String[] {
                "Materialized Views",
                "Complex Views",
                "Simple Views",
                "Subqueries"
        };
        comboBox[1] = new JComboBox(shuffleStringArray(choices[1]));
        qna.put(questions[1], comboBox[1]);

        // Question 3
        questions[2] = new String[] {
                "What database object provide aliases for tables?",
                "Synonym"
        };
        choices[2] = new String[] {
                "Synonym",
                "Subqueries",
                "DDL",
                "Views"
        };
        comboBox[2] = new JComboBox(shuffleStringArray(choices[2]));
        qna.put(questions[2], comboBox[2]);

        // Question 4
        questions[3] = new String[] {
                "What is the long form term for DDL?",
                "Data Definition Language"
        };
        choices[3] = new String[] {
                "Data Definition Language",
                "Data Manipulation Language",
                "Data Transaction Language",
                "Data Dictionary Language"
        };
        comboBox[3] = new JComboBox(shuffleStringArray(choices[3]));
        qna.put(questions[3], comboBox[3]);

        // Question 5
        questions[4] = new String[] {
                "What do you call queries inside of a query",
                "Subquery"
        };
        choices[4] = new String[] {
                "Subquery",
                "Data Manipulation Language",
                "Views",
                "Synonym"
        };
        comboBox[4] = new JComboBox(shuffleStringArray(choices[4]));
        qna.put(questions[4], comboBox[4]);
        return qna;
    }
    private boolean checkAnswer(String k, String v) {
        if (k.toLowerCase().equals(v.toLowerCase())) {
            return true;
        }
        return false;
    }
    private String generateMessage(boolean correct) {
        Random randomObject = new Random();
        if (correct) {
            switch(randomObject.nextInt(4)) {
                case 0:
                    return("Excellent");
                case 1:
                    return("Good!");
                case 2:
                    return("Keep up the good work!");
                case 3:
                    return("Nice work!");
            }
        } else {
            switch(randomObject.nextInt(4)) {
                case 0:
                    return("No. Please try again!");
                case 1:
                    return("Wrong. Try once more");
                case 2:
                    return("Don't give up!");
                case 3:
                    return("No. Keep trying.");
            }
        }
        return null;
    }

    private void inputAnswer() {
        // Create a key-value pair of question and answers
        Map<String[], JComboBox> qna = simulateQuestion();

        // numberOfCorrectAnswers over total
        int numberOfCorrectAnswers = 0;
        int total = qna.size(); // as dictionary gets bigger, become bigger
        String answer = "";
        for (Map.Entry<String[], JComboBox> entry : qna.entrySet()) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            panel.add(new JLabel(entry.getKey()[0]));
            panel.add(entry.getValue());
            String[] options = { "Confirm" };
            int selection = JOptionPane.showOptionDialog(
                    null,
                    panel,
                    "Question",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            answer = (String) entry.getValue().getSelectedItem();

            // Check Answer
            if (checkAnswer(answer, entry.getKey()[1])) {
                numberOfCorrectAnswers++;
                JOptionPane.showMessageDialog(
                        null,
                        generateMessage(true),
                        "Assessment",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        generateMessage(false),
                        "Assessment",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Final Score
        double percentage = (double) numberOfCorrectAnswers / total;
        JOptionPane.showMessageDialog(
                null,
                numberOfCorrectAnswers + "/" + total + "\n" + Math.round(percentage * 100) + "%",
                "Final Assessment",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
