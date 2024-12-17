/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsoftt.quiz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author M.osman
 */
public class eelu {
     private String name;
    private String establishedDate;

    eelu(String name,String establishedDate) {
        this.name = name;
        this.establishedDate = establishedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }
    public void display() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(300, 200));
        panel.setBackground(Color.LIGHT_GRAY);
        Font customFont = new Font("Arial", Font.PLAIN, 18);
        JLabel nameLabel = new JLabel("Name: " + name);
        nameLabel.setFont(customFont);

        JLabel dateLabel = new JLabel("Established: " + establishedDate);
        dateLabel.setFont(customFont);

        // Add labels to the panel
        panel.add(nameLabel);
        panel.add(dateLabel);

    
        JOptionPane.showMessageDialog(null, panel, "EELU Details", JOptionPane.INFORMATION_MESSAGE);
    }

  
}
