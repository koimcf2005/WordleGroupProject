package wordlegroupproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * @author koimc
 */
public class Window extends JFrame implements ActionListener{
        
    // Member variables
    private final Keyboard mKeyboard;
    private String mWord = "";

    
    // Constructor
    public Window() {
        // Just sets basic settings for the window
        setTitle("Wordle Group Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(18, 18, 19));
        setResizable(false);
        setLayout(null);
        setSize(530, 750);
        setVisible(true);
        
        // This will not always be in the constructor
        mKeyboard = new Keyboard(this, this);
        mKeyboard.createButtons();
    }

    @Override
    // actionPerformed runs any time any button is pressed
    // It is up to the programmer to figure out what button was pressed
    public void actionPerformed(ActionEvent e) {
        InputButton usedButton = null;
                
        // This for-loop gets which button was pressed.
        for (int button = 0; button < mKeyboard.getButtonCount(); button++) {
            
            // If the source of the action listener equals this button in the list
            if (e.getSource() == mKeyboard.getButtonByIndex(button)) 
                // Found the button that was clicked!
                usedButton = mKeyboard.getButtonByIndex(button);
        }
        
        // Make sure that this button is not null
        if (usedButton != null) {
            
            // TODO: add real functionality later
            
            // Just testing to make sure it works
            mWord += usedButton.getLetter();
            System.out.println(mWord);
        }
    }
}
