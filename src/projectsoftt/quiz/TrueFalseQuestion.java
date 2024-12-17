package projectsoftt.quiz;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;
    private static List<TrueFalseQuestion> allQuestions = new ArrayList<>(); // List to hold all questions

    public TrueFalseQuestion() {
        super();
    }

@Override
public void displayQuestion() {
    // Create a panel to hold all questions and their corresponding input fields
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setPreferredSize(new Dimension(250, 200));
    java.awt.Font customFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 18);
    // List to hold the input fields for each question
    JTextField[] answerFields = new JTextField[allQuestions.size()];

    // Loop through all the stored questions and add them to the panel
    for (int i = 0; i < allQuestions.size(); i++) {
        TrueFalseQuestion question = allQuestions.get(i);

        // Create a label for the question
        JLabel questionLabel = new JLabel("Question " + (i + 1) + ": " + question.getText());
        panel.add(questionLabel);

        // Create a text field for the student's answer (True/False)
        JTextField answerField = new JTextField(10);
        panel.add(answerField);

        // Add the text field to the array
        answerFields[i] = answerField;
    }

    // Show the questions and input fields in a dialog
    int option = JOptionPane.showConfirmDialog(null, panel, "Enter Answers", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Process the answers if the user pressed "OK"
    if (option == JOptionPane.OK_OPTION) {
        for (int i = 0; i < allQuestions.size(); i++) {
            String studentAnswer = answerFields[i].getText().trim().toLowerCase();

            // Validate the student's answer (must be True or False)
            if (studentAnswer.equals("true") || studentAnswer.equals("false")) {
                boolean isCorrect = allQuestions.get(i).validateAnswer(studentAnswer);

                // Show feedback for each answer
                String resultMessage = isCorrect ? "Correct!" : "Incorrect!";
                JOptionPane.showMessageDialog(null, "Question " + (i + 1) + ": " + resultMessage, "Answer Status", JOptionPane.INFORMATION_MESSAGE);

                // If the answer is correct, increment the score
                if (isCorrect) {
                    Score.getInstance().incrementScore();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid answer for Question " + (i + 1) + "! Please enter 'True' or 'False'.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        // After processing all answers, display the final score
        JOptionPane.showMessageDialog(null, "Your final score is: " + Score.getInstance().getScore(), "Final Score", JOptionPane.INFORMATION_MESSAGE);
    }
}




    @Override
    public void addQuestion() {
        try {
            // Ask the teacher how many True/False questions they want to add
            int numberOfQuestions = Integer.parseInt(
                JOptionPane.showInputDialog(null, "How many True/False questions would you like to add?")
            );

            if (numberOfQuestions < 1) {
                throw new IllegalArgumentException("You must add at least one question!");
            }

            // Loop to add the specified number of questions
            for (int q = 1; q <= numberOfQuestions; q++) {
                JOptionPane.showMessageDialog(null, "Adding question " + q + " of " + numberOfQuestions, "Question Entry", JOptionPane.INFORMATION_MESSAGE);

                // Prompt for the question text
                String questionText = JOptionPane.showInputDialog(null, "Enter the text for question " + q + ":");
                if (questionText == null || questionText.trim().isEmpty()) {
                    throw new IllegalArgumentException("Question text cannot be empty!");
                }
                setText(questionText);

                // Prompt for the correct answer
                String answer = JOptionPane.showInputDialog(null, "Enter the correct answer for question " + q + " (True/False):");
                if (!answer.equalsIgnoreCase("True") && !answer.equalsIgnoreCase("False")) {
                    throw new IllegalArgumentException("Answer must be 'True' or 'False'!");
                }
                correctAnswer = answer.equalsIgnoreCase("True");

                // Create a new TrueFalseQuestion and add it to the list
                TrueFalseQuestion newQuestion = new TrueFalseQuestion();
                newQuestion.setText(questionText);
                newQuestion.correctAnswer = correctAnswer;
                allQuestions.add(newQuestion);

                JOptionPane.showMessageDialog(null, "Question " + q + " added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            JOptionPane.showMessageDialog(null, "All questions added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean validateAnswer(String studentAnswer) {
        // Validate if the student's answer matches the correct answer
        if (!studentAnswer.equalsIgnoreCase("True") && !studentAnswer.equalsIgnoreCase("False")) {
            throw new IllegalArgumentException("Answer must be 'True' or 'False'!");
        }
        return correctAnswer == studentAnswer.equalsIgnoreCase("True");
    }

    @Override
    public String toString() {
        return "True/False Question: " + getText() +
               "\nCorrect Answer: " + (correctAnswer ? "True" : "False");
    }
}
