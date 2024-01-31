package wordlegroupproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * This class creates a basic window with a keyboard
 * @author koimc
 */
public class Window extends JFrame implements ActionListener{
    
    // List of each button the user will press
    private final ArrayList<InputButton> mButtonList = new ArrayList<>();
    
    // Used to organize mButtonList in the order of the qwerty keyboard
    private final char[] qwertyOrder = {
        'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
        'Z', 'X', 'C', 'V', 'B', 'N', 'M'
    };
    
    // Temporary member variable for testing the keyboard
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
    }

    @Override
    // actionPerformed runs any time any button is pressed
    // It is up to the programmer to figure out what button was pressed
    public void actionPerformed(ActionEvent e) {
        InputButton usedButton = null;
        
        // Loops through every button in the list
        for (int button = 0; button < mButtonList.size(); button++) {
            
            // If the source of the action listener equals this button in the list
            if (e.getSource() == mButtonList.get(button)) 
                // Found the button that was clicked!
                usedButton = mButtonList.get(button);
        }
        
        // Make sure that this button is not null
        if (usedButton != null) {
            
            // TODO: add real functionality later
            
            // Just testing to make sure it works
            mWord += usedButton.getLetter();
            System.out.println(mWord);
        }
    }
    
    public void createButtons() {        
        // Loops through every letter in the order or 'qwerty'
        for (int letter = 0; letter < qwertyOrder.length; letter++) {
            // Add a new button to the list and assign its letter and action listener
            mButtonList.add(new InputButton((qwertyOrder[letter]), this));
        }
        
        // This for-loop adds the buttons to the screen and sets their coordinates and size
        for (int button = 0; button < mButtonList.size(); button++) {
            if (button < 10) {
                add(mButtonList.get(button));
                mButtonList.get(button).setBounds(23 + (button * 47), 480, 42, 58);
            }
            else if (button < 19) {
                add(mButtonList.get(button));
                mButtonList.get(button).setBounds(44 + ((button - 10)* 47), 546, 42, 58);
            }
            else if (button < 26){
                add(mButtonList.get(button));
                mButtonList.get(button).setBounds(91 + ((button - 19) * 47), 612, 42, 58);    
            }
        }
        
        // Adds the backspace button
        mButtonList.add(new InputButton('\b', this));
        add(mButtonList.get(26));
        mButtonList.get(26).setText("Delete");
        mButtonList.get(26).setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        mButtonList.get(26).setBounds(420, 612, 65, 58);
        
        // Adds the enter button which has a placeholder value of ' '
        mButtonList.add(new InputButton(' ', this));
        add(mButtonList.get(27));
        mButtonList.get(27).setText("Enter");
        mButtonList.get(27).setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        mButtonList.get(27).setBounds(20, 612, 65, 58);
    }
}
