package wordle_gui;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @author Koi
 */
public class Keyboard {
    private final JFrame window;
    private final ActionListener listener;
    private final ArrayList<InputButton> mButtonList = new ArrayList<>();
    private final String qwertyOrder = "QWERTYUIOPASDFGHJKLZXCVBNM";
    
    // Constructor
    public Keyboard(ActionListener listener, JFrame window) {
        this.listener = listener;
        this.window = window;
    }
    
    public void createButtons() {
        // Loops through every letter in the order of 'qwerty'
        for (int letter = 0; letter < qwertyOrder.length(); letter++) {
            // Add a new button to the list and assign its letter and action listener
            mButtonList.add(new InputButton(qwertyOrder.charAt(letter), listener));
        }
        
        // This for-loop adds the buttons to the screen and sets their coordinates and size
        for (int button = 0; button < mButtonList.size(); button++) {
            
            // This executes for the first 10 buttons. Creates "QWERTYUIOP"
            if (button < 10) {
                window.add(mButtonList.get(button));
                mButtonList.get(button).setBounds(23 + ((button - 0) * 47), 480, 42, 58);
            }
            // This executes for the 9 middle buttons. Creates "ASDFGHJKL"
            else if (button < 19) {
                window.add(mButtonList.get(button));
                mButtonList.get(button).setBounds(44 + ((button - 10) * 47), 546, 42, 58);
            }
            // This executes for the last 7 buttons. Creates "ZXCVBNM"
            else if (button < 26){
                window.add(mButtonList.get(button));
                mButtonList.get(button).setBounds(91 + ((button - 19) * 47), 612, 42, 58);    
            }
        }
        
        // Adds the backspace button
        mButtonList.add(new InputButton('\b', listener));
        window.add(mButtonList.get(26));
        mButtonList.get(26).setText("Delete");
        mButtonList.get(26).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));

        mButtonList.get(26).setBounds(420, 612, 65, 58);
        
        // Adds the enter button which has a placeholder value of ' '
        mButtonList.add(new InputButton(' ', listener));
        window.add(mButtonList.get(27));
        mButtonList.get(27).setText("Enter");
        mButtonList.get(27).setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        mButtonList.get(27).setBounds(20, 612, 65, 58);
    }
    
    // Getters
    public int getButtonCount() {
        return mButtonList.size();
    }
    
    public InputButton getButtonByIndex(int index) {
        return mButtonList.get(index);
    }
    
    public InputButton getButtonByText(String text) {
        InputButton retButton = null;
        
        for (int button = 0; button < mButtonList.size(); button++) {
            if (mButtonList.get(button).getText().equals(text)) {
                retButton = mButtonList.get(button);
            }
        }
        return retButton;
    }
    
    public void hide() {
        for (int button = 0; button < mButtonList.size(); button++) {
            mButtonList.get(button).setVisible(false);
        }
    }
    
    public void show() {
        for (int button = 0; button < mButtonList.size(); button++) {
            mButtonList.get(button).setVisible(true);
        }
    }
}
