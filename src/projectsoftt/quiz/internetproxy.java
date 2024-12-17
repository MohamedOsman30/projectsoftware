/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoftt.quiz;

import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author M.osman
 */
public class internetproxy  implements internetserivceprovider {

    private List<String> blockedSites = Arrays.asList("twitter", "youtube", "facebook");
    @Override
    public String servesite(String url) {
        // Create the main frame
        JFrame frame = new JFrame("Site Blocker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Create the panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.LIGHT_GRAY);

        // Create and configure the text field for user input
        JTextField siteInputField = new JTextField(20);
        siteInputField.setMaximumSize(new Dimension(300, 30));

        // Create the label to display messages
        JLabel resultLabel = new JLabel("Enter a site to check:");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create the button to check the site
        JButton checkButton = new JButton("Check Site");
        checkButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add action listener to the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputSite = siteInputField.getText().trim();
                String message;
                if (blockedSites.contains(inputSite.toLowerCase())) {
                    message = "This site is blocked";
                } else {
                    message = new We().servesite(inputSite);
                }
                resultLabel.setText(message);
            }
        });

        // Add components to the panel
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(siteInputField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(checkButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(resultLabel);

        // Add panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);

        return null; // GUI handles the result display
    }

   
  
}
