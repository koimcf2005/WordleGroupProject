package wordlegroupproject;

import WordSelection.WordSelection;
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
    private static WordSelection mSelect;
    
    private static int wordLength = 5;
    private static int guessCount = 7;
    
    private static String selectedWord;
    private static String currentGuess = "";
    
    private static wordCheck mCheck;
    
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
        
        // Instantiates the window and creates the keyboard / start screen
        mWindow = new Window();
        mWindow.createKeyboard();
        
        mWindow.createSettings();
        mWindow.getSettings();
        
        mWindow.getKeyboard().hide();
        mWindow.getSettings().show();

        // TODO: Any functionality
        mSelect = new WordSelection();
        mSelect.listExtraction();
        
        mCheck = new wordCheck(mWindow);
       
        
    }
    
   /**
    * This function gets all input from the Window class.
    * @param key The InputButton that has been clicked
    * @author Koi McFarland
    */
    public static void getKeyboardInput(InputButton key) {
        
        //for(int i = 0; i < selectedWord.length(); i++){
        
        
            switch (key.getLetter()) {
                case ' ' -> { // Enter key
                    //System.out.println("Enter was pressed");
                    System.out.println(currentGuess);
                    //currentGuess = "";
                }
                case '\b' -> { // Delete key
                    //System.out.println("Delete was pressed");
                     currentGuess = currentGuess.substring(0, currentGuess.length() - 1);
                }
                default -> { // Letter key
                    //System.out.println(key.getLetter() + " was pressed");
                    currentGuess += key.getLetter();
                }
            }
        //}
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
            selectedWord = mSelect.randomWord(wordLength);
            System.out.println(selectedWord);
//            mCheck.checkGuess(selectedWord, currentGuess, 1);
        }
        
        if (wordLength > 7) wordLength = 7;
        else if (wordLength < 3) wordLength = 3;
        if (guessCount > 7) guessCount = 7;
        else if (guessCount < 3) guessCount = 3;
        
        mWindow.getSettings().setWordLengthLabel(wordLength);
        mWindow.getSettings().setGuessCountLabel(guessCount);
        
    }
}
