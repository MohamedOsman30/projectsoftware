/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoftt.quiz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author M.osman
 */
public class Newnews1 implements news {

    @Override
    public void shownews() {
         JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(600, 300));
        panel.setBackground(Color.LIGHT_GRAY);
        Font customFont = new Font("Arial", Font.PLAIN, 16);
        JLabel titleLabel = new JLabel("The Journey of Dr. Basyouni: Achieving Excellence Through His Master's Thesis");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextArea articleContent = new JTextArea(
            "Introduction\n" +
            "In the world of medicine, continuous education and research play a pivotal role in advancing healthcare practices. " +
            "Dr. Basyouni, a dedicated physician, exemplifies this commitment through his recent achievement of a master's thesis. " +
            "This article explores his journey, the significance of his research, and its potential impact on the medical community."
        );
        articleContent.setFont(customFont);
        articleContent.setLineWrap(true);
        articleContent.setWrapStyleWord(true);
        articleContent.setEditable(false);
        articleContent.setBackground(Color.LIGHT_GRAY);

        // Add title and content to the panel
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(articleContent);

        // Display the panel in a dialog
        JOptionPane.showMessageDialog(null, panel, "Article Details", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
