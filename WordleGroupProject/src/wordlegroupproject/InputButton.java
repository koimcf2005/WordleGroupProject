package wordlegroupproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * This is a class for a basic button (Will mostly be used for the keyboard)
 * @author koimc
 */
public class InputButton extends JButton {
    
    // Member variables
    private final char mLetter;
    
    // Constructor
    public InputButton(char input, ActionListener listener) {
        setText(String.valueOf(input));
        mLetter = input;
        addActionListener(listener);
        setFocusable(false);
        setBackground(new Color(129, 131, 132));
        setBorder(null);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
        setForeground(Color.WHITE);
    }
    
    public char getLetter() {
        return mLetter;
    }  
}
