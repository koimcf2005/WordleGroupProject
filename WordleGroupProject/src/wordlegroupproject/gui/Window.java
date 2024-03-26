package wordlegroupproject.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import wordlegroupproject.WordleGroupProject;

/**
 * @author koimc
 */
public class Window extends JFrame implements ActionListener {
        
    // Member variables
    private Keyboard mKeyboard;
    private WordGrid mGrid; 
    private Settings mSettings;
    
    // Constructor
    public Window() {
        // Just sets basic settings for the window
        setTitle("Wordle Group Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 735);
        getContentPane().setBackground(new Color(18, 18, 19));
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    public void createSettings() {
        mSettings = new Settings(this, this);
        mSettings.hide();
    }
    
    public void createKeyboard() {
        // Creates the keyboard
        mKeyboard = new Keyboard(this, this);
        mKeyboard.createButtons();
        mKeyboard.hide();
    }
    
    public void createGrid(int wordLength, int guessCount) {
        // Creates the word grid
        mGrid = new WordGrid(wordLength, guessCount, this);
        mGrid.calculateBounds(wordLength, guessCount);
        add(mGrid);
        mGrid.hide();
    }
    
    public Keyboard getKeyboard() { return mKeyboard; }
    public WordGrid getGrid() { return mGrid; }
    public Settings getSettings() { return mSettings; }
    
    @Override
    // actionPerformed runs any time any button is pressed
    // It is up to the programmer to figure out what button was pressed
    public void actionPerformed(ActionEvent e) {
        InputButton keyPressed = null;
                
        // This for-loop gets which button was pressed if it was from the keyboard.
        for (int button = 0; button < mKeyboard.getButtonCount(); button++) {
            // If the source of the action listener equals this button in the list
            if (e.getSource() == mKeyboard.getButtonByIndex(button)) 
                // Found the button that was clicked!
                keyPressed = mKeyboard.getButtonByIndex(button);
        }
        
        // Make sure that this button is not null
        if (keyPressed != null) {
            WordleGroupProject.getKeyboardInput(keyPressed);
        }
        else if (e.getSource() == mSettings.getWordLengthButton0())
            WordleGroupProject.getSettingsInput(mSettings.getWordLengthButton0());
        else if (e.getSource() == mSettings.getWordLengthButton1())
            WordleGroupProject.getSettingsInput(mSettings.getWordLengthButton1());
        else if (e.getSource() == mSettings.getGuessCountButton0())
            WordleGroupProject.getSettingsInput(mSettings.getGuessCountButton0());
        else if (e.getSource() == mSettings.getGuessCountButton1())
            WordleGroupProject.getSettingsInput(mSettings.getGuessCountButton1());
        else if (e.getSource() == mSettings.getStartButton())
            WordleGroupProject.getSettingsInput(mSettings.getStartButton());
        else
            System.out.println("Error, action called but there was not button.");
    }
}
