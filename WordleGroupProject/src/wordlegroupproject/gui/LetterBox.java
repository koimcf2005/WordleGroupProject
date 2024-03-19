package wordlegroupproject.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author koimc
 */
public class LetterBox extends JPanel {
    private JLabel letterLabel;
    
    public LetterBox() {
        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(58, 58, 60)));
        setFocusable(false);
        setBackground(new Color(18, 18, 19));
        setLayout(new BorderLayout());
        
        letterLabel = new JLabel();
        letterLabel.setFont(new Font("Segoe UI", 1, 36));
        letterLabel.setHorizontalAlignment(SwingConstants.CENTER);
        letterLabel.setVerticalAlignment(SwingConstants.CENTER);
        letterLabel.setForeground(Color.WHITE);
        letterLabel.setPreferredSize(new Dimension(60, 60));
        add(letterLabel, BorderLayout.CENTER);
    }
    
    public void setLetter(char letter) {
        letterLabel.setText(Character.toString(letter));
    }
 
    public void setAsIncorrectLetter() {
        setBackground(new Color(58, 58, 60));
        setBorder(null);
    }
    
    public void setAsCorrectLetter() {
        setBackground(new Color(83, 141, 78));
        setBorder(null);
    }
    
    public void setAsWrongSpot() {
        setBackground(new Color(181, 159, 59));
        setBorder(null);
    }
    
    public void setAsEmpty() {
        setBackground(new Color(18, 18, 19));
        setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(58, 58, 60)));
        letterLabel.setText("");
    }
}
