package projectsoftt.quiz;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MultipleChoiceQuestion extends Question {
    private List<String> options;
    private String correctAnswer;
    private List<MultipleChoiceQuestion> allQuestions; 

    public MultipleChoiceQuestion() {
        super();
        options = new ArrayList<>();
        allQuestions = new ArrayList<>(); 
    }
    
    
    
      @Override
    public void addQuestion() {
        try {
            int numberOfQuestions = Integer.parseInt(
                JOptionPane.showInputDialog(null, "How many multiple-choice questions would you like to add?")
            );
            if (numberOfQuestions < 1) {
                throw new IllegalArgumentException("You must add at least one question!");
            }
            for (int q = 1; q <= numberOfQuestions; q++) {
                JOptionPane.showMessageDialog(null, "Adding question " + q + " of " + numberOfQuestions, "Question Entry", JOptionPane.INFORMATION_MESSAGE);

                
                String questionText = JOptionPane.showInputDialog(null, "Enter the text for question " + q + ":");
                if (questionText == null || questionText.trim().isEmpty()) {
                    throw new IllegalArgumentException("Question text cannot be empty!");
                }
                setText(questionText);

                // Prompt for the number of options
                int numberOfOptions = Integer.parseInt(
                    JOptionPane.showInputDialog(null, "How many options for question " + q + "?")
                );
                if (numberOfOptions < 2) {
                    throw new IllegalArgumentException("A question must have at least two options!");
                }

                // Gather the options
                options = new ArrayList<>();
                for (int i = 0; i < numberOfOptions; i++) {
                    String option = JOptionPane.showInputDialog(null, "Enter option " + (i + 1) + " for question " + q + ":");
                    if (option == null || option.trim().isEmpty()) {
                        throw new IllegalArgumentException("Option text cannot be empty!");
                    }
                    options.add(option);
                }

                // Prompt for the correct answer
                correctAnswer = JOptionPane.showInputDialog(
                    null,
                    "Enter the correct answer for question " + q + " (text must match one of the options):"
                );
                if (!options.contains(correctAnswer)) {
                    throw new IllegalArgumentException("Correct answer must match one of the options!");
                }

                // Store the question
                MultipleChoiceQuestion newQuestion = new MultipleChoiceQuestion();
                newQuestion.setText(questionText);
                newQuestion.options = new ArrayList<>(options);
                newQuestion.correctAnswer = correctAnswer;
                allQuestions.add(newQuestion);                                           // Add the question to the list

                JOptionPane.showMessageDialog(null, "Question " + q + " added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }

            // Display all questions
            StringBuilder allQuestionsDisplay = new StringBuilder("All Questions:\n");
            for (MultipleChoiceQuestion question : allQuestions) {
                allQuestionsDisplay.append(question.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, allQuestionsDisplay.toString(), "All Questions", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null, "All questions added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
private boolean questionDisplayed = false; 
@Override
public void displayQuestion() {
    // If the question is already displayed, return early
    if (questionDisplayed) {
        return;
    }
    java.awt.Font customFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 18);
// Create a panel to hold all questions and their corresponding input fields
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setPreferredSize(new Dimension(250, 200));
    // List to hold the combo boxes for each question
    JComboBox<String>[] answerFields = new JComboBox[allQuestions.size()];
    // Loop through all the stored questions and add them to the panel
    for (int i = 0; i < allQuestions.size(); i++) {
        MultipleChoiceQuestion question = allQuestions.get(i);
        // Create a label for the question
        JLabel questionLabel = new JLabel("Question " + (i + 1) + ": " + question.getText());
        questionLabel.setFont(customFont); // Set custom font for the question label
        panel.add(questionLabel);
        // Ensure the options are not empty
        if (question.options != null && !question.options.isEmpty()) {
            // Create a combo box for the multiple-choice options
            String[] optionsArray = question.options.toArray(new String[0]);
            JComboBox<String> answerField = new JComboBox<>(optionsArray);
            answerField.setFont(customFont); // Set custom font for the combo box
            panel.add(answerField);
            // Add the combo box to the array
            answerFields[i] = answerField;
        } else {
            // If there are no options, show an error message and skip this question
            JOptionPane.showMessageDialog(null, "No options available for Question " + (i + 1), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Show the questions and input fields in a dialog
    int option = JOptionPane.showConfirmDialog(null, panel, "Enter Answers", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    // Mark the flag to prevent re-displaying
    questionDisplayed = true;

    // Process the answers if the user pressed "OK"
    if (option == JOptionPane.OK_OPTION) {
        for (int i = 0; i < allQuestions.size(); i++) {
            String studentAnswer = (String) answerFields[i].getSelectedItem();

            // Validate the student's answer (checking if it's a valid option)
            if (studentAnswer != null && !studentAnswer.trim().isEmpty()) {
                boolean isCorrect = allQuestions.get(i).validateAnswer(studentAnswer);

                // Show feedback for each answer
                String resultMessage = isCorrect ? "Correct!" : "Incorrect!";
                JOptionPane.showMessageDialog(null, "Question " + (i + 1) + ": " + resultMessage, "Answer Status", JOptionPane.INFORMATION_MESSAGE);

                // If the answer is correct, increment the score
                if (isCorrect) {
                    Score.getInstance().incrementScore();
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid answer for Question " + (i + 1) + "! Please select an answer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // After processing all answers, display the final score
        // JOptionPane.showMessageDialog(null, "Your final score is: " + Score.getInstance().getScore(), "Final Score", JOptionPane.INFORMATION_MESSAGE);
    }
}








  

    @Override
    public String toString() {
        return "Multiple Choice Question: " + getText() +
                "\nOptions: " + options +
                "\nCorrect Answer: " + correctAnswer;
    }

  // In MultipleChoiceQuestion class
public boolean validateAnswer(String studentAnswer) {
    // Check if the student's answer matches the correct answer
    return studentAnswer != null && studentAnswer.equalsIgnoreCase(correctAnswer);
}

}
