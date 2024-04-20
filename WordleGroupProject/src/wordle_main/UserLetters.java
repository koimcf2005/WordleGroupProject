package wordle_main;

import wordle_gui.GameResults;
import wordle_gui.InputButton;
import wordle_gui.Window;

/**
 * @author Andrew
 */
public class UserLetters {
    // Object variables
    private Window mWindow = WordleGroupProject.getWindow();
    private static GameResults mResult;
    // Primitive variables
    public static String currentGuess = "";
    public static String lastGuess;
    public static int currentRound = 0;

    public void getKeyboardInput(InputButton key, String selectedWord, int guessLimit) {
        //Breaks from function when game is won
        if (WordCheck.getWin() == true)
            return;
        
        mResult = new GameResults();
        switch (key.getLetter()) {
            //Submits a guess and only works when there are enough letters
            case ' ' -> { // Enter key
                if (currentGuess.length() == selectedWord.length()) {
                    System.out.println(currentGuess);
                    WordCheck.checkGuess(selectedWord, currentGuess, currentRound);
                    currentRound++;
                    currentGuess = "";
                }
            }
            //Simply deletes the prior character from the current guess being made
            case '\b' -> { // Delete key

                try {
                    currentGuess = currentGuess.substring(0, currentGuess.length() - 1);
                    mWindow.getGrid().getBox(currentRound, currentGuess.length()).setLetter(' ');
                } catch (Exception e) {
                    currentGuess = "";
                }
            }
            //Store the letter in the string for the current guess and displays it 
            default -> { // Letter key
                if (currentGuess.length() < selectedWord.length()) {
                    currentGuess += key.getLetter();
                    mWindow.getGrid().getBox(currentRound, currentGuess.length() - 1).setLetter(key.getLetter());
                }
            }
        }
        //Stores final guess for output in results and then displays results
        if(currentRound == guessLimit - 1) {
            lastGuess = currentGuess;
        }
        if(currentRound == guessLimit) {
            mResult.unhidden(selectedWord);
        }

    }
    
    //Allows the user to play another round after either winning or losing 
    public void reset() {
        mWindow = WordleGroupProject.getWindow();
        currentGuess = "";
        lastGuess = "";
        currentRound = 0;
        WordCheck.setHasWon(false);
        WordCheck.setWindow(WordleGroupProject.getWindow());
    }
    
    //Getters for guess and round
    public String getCurrentGuess(){
        return currentGuess;
    }
    
    public int getCurrentRound(){
        return currentRound;
    }
}
