package projectsoftt.roles;

import javax.swing.*;
import java.awt.*;

public class Manager extends User {
    private String name;
    private int age;
    private String address;
    private String officeNumber;
    private String role;

    public Manager() {
        // Default constructor
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
        JLabel officeLabel = new JLabel("Office Number:");
        officeLabel.setFont(customFont);
        JTextField officeField = new JTextField();
        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setFont(customFont);
        JTextField roleField = new JTextField();

        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(addressLabel);
        formPanel.add(addressField);
        formPanel.add(officeLabel);
        formPanel.add(officeField);
        formPanel.add(roleLabel);
        formPanel.add(roleField);

        formPanel.setPreferredSize(new Dimension(400, 200));
        int result = JOptionPane.showConfirmDialog(null, formPanel, "Manager Profile",
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
            officeNumber = officeField.getText();
            role = roleField.getText();

            if (!name.isEmpty() && age > 0 && !address.isEmpty() && !officeNumber.isEmpty() && !role.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Manager Profile Created Successfully!\n" + this,
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
        // Show manager information in a dialog box
        String info = "Manager Profile:\n" +
                      "Name: " + name + "\n" +
                      "Age: " + age + "\n" +
                      "Address: " + address + "\n" +
                      "Office Number: " + officeNumber + "\n" +
                      "Role: " + role;
        JOptionPane.showMessageDialog(null, info, "Manager Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
