package wordlegroupproject;

import javax.swing.JButton;
import wordlegroupproject.gui.InputButton;
import wordlegroupproject.gui.Window;

/**
 * This is the main class
 * 
 * @author Koi McFarland
 * @author Andrew Burbage
 * @author Kayla Dixon
 */
public class WordleGroupProject {
    // Temp variable
    private static Window mWindow;
    
    private static int wordLength = 5;
    private static int guessCount = 7;
    
    public static void main(String[] args) {
        
        /**
         * You can change aspects of the grid in the following ways:
         *      window.getGrid().getBox(row, column).setAsCorrectLetter();
         *      window.getGrid().getBox(row, column).setAsEmpty();
         *      window.getGrid().getBox(row, column).setAsIncorrectLetter();
         *      window.getGrid().getBox(row, column).setAsWrongSpot();
         *      window.getGrid().getBox(row, column).setLetter('char');
         *      window.getGrid().hide();
         *      window.getGrid().show();
         * 
         * You can use aspects of the keyboard in the following ways:
         *      window.getKeyboard().getButtonCount();
         *      window.getKeyboard().getButtonByIndex(index);
         *      window.getKeyboard().getButtonByText(string);
         *      window.getKeyboard().getButtonByText(string).setAsGrey();
         *      window.getKeyboard().getButtonByText(string).setAsNormal();
         *      window.getKeyboard().hide();
         *      window.getKeyboard().show();
         * 
         * IMPORTANT NOTE: the grid is not created in main unlike other elements
         *      If you want to use the grid, check if it is null first!
         */
        
        // Instantiates the window and creates the keyboard / start screen
        mWindow = new Window();
        mWindow.createKeyboard();
        
        mWindow.createSettings();
        mWindow.getSettings().show();

        // TODO: Any functionality
    }
    
   /**
    * This function gets all input from the Window class.
    * @param key The InputButton that has been clicked
    * @author Koi McFarland
    */
    public static void getKeyboardInput(InputButton key) {
        switch (key.getLetter()) {
            case ' ' -> { // Enter key
                System.out.println("Enter was pressed");
            }
            case '\b' -> { // Delete key
                System.out.println("Delete was pressed");
            }
            default -> { // Letter key
                System.out.println(key.getLetter() + " was pressed");
            }
        }
    }
    
    public static void getSettingsInput(JButton input) {
        if (input.equals(mWindow.getSettings().getWordLengthButton0()))
            wordLength -= 1;
        else if (input.equals(mWindow.getSettings().getWordLengthButton1()))
            wordLength += 1;
        else if (input.equals(mWindow.getSettings().getGuessCountButton0()))
            guessCount -= 1;
        else if (input.equals(mWindow.getSettings().getGuessCountButton1()))
            guessCount += 1;
        else if (input.equals(mWindow.getSettings().getStartButton())) {
            
            // This is where the game starts
            // Creates the grid and reveals the keyboard
            mWindow.createGrid(wordLength, guessCount);
            mWindow.getGrid().show();
            mWindow.getKeyboard().show();
            mWindow.getSettings().hide();
        }
        
        if (wordLength > 7) wordLength = 7;
        else if (wordLength < 3) wordLength = 3;
        if (guessCount > 7) guessCount = 7;
        else if (guessCount < 3) guessCount = 3;
        
        mWindow.getSettings().setWordLengthLabel(wordLength);
        mWindow.getSettings().setGuessCountLabel(guessCount);
    }
}
