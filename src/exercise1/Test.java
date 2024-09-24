package exercise1;

import javax.swing.JOptionPane;

public class Test {
    public Test() {
        this.inputAnswer();
    }
    private String simulateQuestion(int itr) {
        String[] questions = {
            "What database object are SELECT queries stored in?",
            "Where are snapshots of database tables stored in?",
            "What database object provide aliases for tables?",
            "What is the long form term for DDL?",
            "What do you call queries inside of a query?"
        };
        return questions[itr];
    }
    private boolean checkAnswer(String userInput, int itr) {
        boolean correct = false;
        String[] answers = {
                "Views",
                "Materialized Views",
                "Synonym",
                "Data Definition Language",
                "Subquery"
        };
        if (userInput.toLowerCase().equals(answers[itr].toLowerCase())) {
            correct = true;
        }
        return correct;
    }
    private String generateMessage(boolean correct) {
        int randomNumber = (int) (Math.random() * 4); //0 to 3
        String message;
        String[] correctAnswer = {
                "Excellent!",
                "Good!",
                "Keep up the good work!",
                "Nice work!"
        };
        String[] wrongAnswer = {
                "No. Please try again!",
                "Wrong. Try once more",
                "Don't give up!",
                "No. Keep trying."
        };
        if (correct) {
            message = correctAnswer[randomNumber];
        } else {
            message = wrongAnswer[randomNumber];
        }
        return message;
    }
    private void inputAnswer() {
        String answer;
        int numberOfCorrectAnswers = 0;
        int total = 4;
        for (int i = 0; i < total; i++) {
            answer = JOptionPane.showInputDialog(simulateQuestion(i));
            if(checkAnswer(answer, i)) {
                numberOfCorrectAnswers++;
                JOptionPane.showMessageDialog(null, generateMessage(true), "Assessment", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, generateMessage(false), "Assessment", JOptionPane.ERROR_MESSAGE);
            }
        }
        double percentage = (double) numberOfCorrectAnswers / total;
        JOptionPane.showMessageDialog(null, numberOfCorrectAnswers + "/" + total + "\n" + Math.round(percentage * 100) + "%", "Final Assessment", JOptionPane.INFORMATION_MESSAGE);
    }
}
