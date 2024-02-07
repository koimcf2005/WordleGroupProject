package wordlegroupproject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 * @author koimc
 */
public class LetterBox extends JTextPane {
    public LetterBox() {
        setBorder(BorderFactory.createMatteBorder(2, 3, 2, 3, new Color(58, 58, 60)));
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
        setFocusable(false);
        setForeground(Color.WHITE);
        setBackground(new Color(18, 18, 19));
        
        StyledDocument doc = getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }
    
    public void setLetter(char letter) {
        setText(Character.toString(letter));
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
        setBorder(BorderFactory.createMatteBorder(2, 3, 2, 3, Color.DARK_GRAY));
        setText("");
    }
    
}
