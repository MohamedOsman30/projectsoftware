package projectsoftt.roles;

import javax.swing.*;
import java.awt.*;



public class Teacher extends User {
    private String name;
    private int age;
    private String address;
    private String subject;
    private String department;

    public Teacher() {
        // Default constructor
    }

    @Override
    public void createProfile() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        java.awt.Font customFont = new java.awt.Font("Arial", java.awt.Font.PLAIN, 18);
        // Create labels and input fields for each attribute
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(customFont);
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(customFont);
        JTextField ageField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(customFont);
        JTextField addressField = new JTextField();
        JLabel subjectLabel = new JLabel("Subject:");
        subjectLabel.setFont(customFont);
        JTextField subjectField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setFont(customFont);
        JTextField departmentField = new JTextField();
      
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(subjectLabel);
        formPanel.add(subjectField);
        formPanel.add(departmentLabel);
        formPanel.add(departmentField);
  
        formPanel.setPreferredSize(new Dimension(400, 200)); 

        int result = JOptionPane.showConfirmDialog(null, formPanel, "Teacher Profile",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            name = nameField.getText();
            try {
                age = Integer.parseInt(ageField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Age must be a valid number.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                createProfile();
                return;
            }
            address = addressField.getText();
            subject = subjectField.getText();
            department = departmentField.getText();
            if (!name.isEmpty() && age > 0 && !address.isEmpty() && !subject.isEmpty() && !department.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Teacher Profile Created Successfully!\n" ,
                        "Profile Created", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "All fields must be filled out.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                createProfile();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Profile creation cancelled.",
                    "Cancelled", JOptionPane.WARNING_MESSAGE);
        }
    }

    
    @Override
    public void displayinformation() {
        // Show teacher information in a dialog box
        String info = "Teacher Profile:\n" +
                      "Name: " + name + "\n" +
                      "Age: " + age + "\n" +
                      "Address: " + address + "\n" +
                      "Subject: " + subject + "\n" +
                      "Department: " + department;
        JOptionPane.showMessageDialog(null, info, "Teacher Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
