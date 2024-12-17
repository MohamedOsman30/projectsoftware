package projectsoftt.roles;

import javax.swing.*;
import java.awt.*;

public class Student extends User {
    private String name;
    private int age;
    private String address;
    private String gradeLevel;
    private String major;

    public Student() {
        
    }

    @Override
    public void createProfile() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        java.awt.Font customFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 18);
       JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(customFont);
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(customFont);
        JTextField ageField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(customFont);
        JTextField addressField = new JTextField();
        JLabel gradeLabel = new JLabel("Grade Level (e.g., First, Second...):");
        gradeLabel.setFont(customFont);
        JTextField gradeField = new JTextField();
        JLabel majorLabel = new JLabel("GPA:");
        majorLabel.setFont(customFont);
        JTextField majorField = new JTextField();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(gradeLabel);
        formPanel.add(gradeField);
        formPanel.add(majorLabel);
        formPanel.add(majorField);

        int result = JOptionPane.showConfirmDialog(null, formPanel, "Student Profile",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                name = nameField.getText();
                age = Integer.parseInt(ageField.getText());
                address = addressField.getText();
                gradeLevel = gradeField.getText();
                major = majorField.getText();

                if (!name.isEmpty() && !address.isEmpty() && !gradeLevel.isEmpty() && !major.isEmpty()) {
                    String message = "Student Profile Details:\n\n" +
                            "Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Address: " + address + "\n" +
                            "Grade Level: " + gradeLevel + "\n" +
                            "Major: " + major;
                    JOptionPane.showMessageDialog(null, message, "Profile Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "All fields must be filled out.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Age must be a valid number.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Override displayinformation() method
    @Override
    public void displayinformation() {
       
        String info = "Student Profile:\n" +
                      "Name: " + name + "\n" +
                      "Age: " + age + "\n" +
                      "Address: " + address + "\n" +
                      "Grade Level: " + gradeLevel + "\n" +
                      "Major: " + major;
        JOptionPane.showMessageDialog(null, info, "Student Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
