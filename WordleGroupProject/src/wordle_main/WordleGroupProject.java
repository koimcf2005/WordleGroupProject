package wordle_main;

import wordle_word_selection.WordSelection;
import javax.swing.JButton;
import wordle_gui.GameResults;
import wordle_gui.InputButton;
import wordle_gui.Window;

/**
 * This is the main class
 * 
 * @author Koi McFarland
 * @author Andrew Burbage
 * @author Kayla Dixon
 */
public class WordleGroupProject {
    // Object variables
    public static Window mWindow;
    private static WordSelection mSelect;
    private static WordCheck mCheck;
    private static UserLetters mUserLetters;
    // Primitive variables
    private static int wordLength = 5;
    private static int guessCount = 7;
    private static String selectedWord;
    
    public static void main(String[] args) {
        
        /**
         * You can change aspects of the grid in the following ways:
         *      mWindow.getGrid().getBox(row, column).setAsCorrectLetter();
         *      mWindow.getGrid().getBox(row, column).setAsEmpty();
         *      mWindow.getGrid().getBox(row, column).setAsIncorrectLetter();
         *      mWindow.getGrid().getBox(row, column).setAsWrongSpot();
         *      mWindow.getGrid().getBox(row, column).setLetter('char');
         *      mWindow.getGrid().getWordLength();
         *      mWindow.getGrid().getGuessCount();
         *      mWindow.getGrid().hide();
         *      mWindow.getGrid().show();
         * 
         * You can use aspects of the keyboard in the following ways:
         *      mWindow.getKeyboard().getButtonCount();
         *      mWindow.getKeyboard().getButtonByIndex(index);
         *      mWindow.getKeyboard().getButtonByText(string);
         *      mWindow.getKeyboard().getButtonByText(string).setAsGrey();
         *      mWindow.getKeyboard().getButtonByText(string).setAsNormal();
         *      mWindow.getKeyboard().hide();
         *      mWindow.getKeyboard().show();
         * 
         * IMPORTANT NOTE: the grid is not created in main unlike other elements
         *      If you want to use the grid, check if it is null first!
         */
        
        // Instantiates the gui
        mWindow = new Window();
        mWindow.createKeyboard();
        
        mWindow.createStartMenu();
        mWindow.getStartMenu();
        
        mWindow.getKeyboard().hide();
        mWindow.getStartMenu().show();

        // Instantiates the logic classes
        mSelect = new WordSelection();
        mSelect.listExtraction();
        mUserLetters = new UserLetters();
       
    }
    
   /**
    * This function gets all input from the Window class.
    * @param key The InputButton that has been clicked
    * @author Koi McFarland
    */
    public static void getKeyboardInput(InputButton key) {
        mUserLetters.getKeyboardInput(key, selectedWord, guessCount);
    }    
    
    public static void getStartMenuInput(JButton input) {
        if (input.equals(mWindow.getStartMenu().getWordLengthButton0())) {
            wordLength -= 1 * boolToInt(wordLength > 3);
        } else if (input.equals(mWindow.getStartMenu().getWordLengthButton1())) {
            wordLength += 1 * boolToInt(wordLength < 7);
        } else if (input.equals(mWindow.getStartMenu().getGuessCountButton0())) {
            guessCount -= 1 * boolToInt(guessCount > 3);
        } else if (input.equals(mWindow.getStartMenu().getGuessCountButton1())) {
            guessCount += 1 * boolToInt(guessCount < 7);
        } else if (input.equals(mWindow.getStartMenu().getStartButton())) {
            // This is where the game starts
            // Creates the grid and reveals the keyboard
            // Hides the StartMenu and selects a random word
            mWindow.createGrid(wordLength, guessCount);
            mWindow.getGrid().show();
            mWindow.getKeyboard().show();
            mWindow.getStartMenu().hide();
            selectedWord = mSelect.randomWord(wordLength);
            System.out.println(selectedWord);
            
//             mCheck.checkGuess(selectedWord, "black", 0);
        }

        mWindow.getStartMenu().setWordLengthLabel(wordLength);
        mWindow.getStartMenu().setGuessCountLabel(guessCount);
    }
    
    private static int boolToInt(boolean bool) {
        return bool ? 1 : 0;
    }
 
}
