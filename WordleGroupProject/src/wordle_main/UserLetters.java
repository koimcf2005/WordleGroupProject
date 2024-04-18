package wordle_main;

import wordle_gui.GameResults;
import wordle_gui.InputButton;
import wordle_gui.Window;

/**
 * @author andre
 */
public class UserLetters {
    // Object variables
    private Window mWindow = WordleGroupProject.mWindow;
    private static GameResults mResult;
    // Primitive variables
    public static String currentGuess = "";
    public static int currentRound = 0;

    public void getKeyboardInput(InputButton key, String selectedWord, int guessLimit) {
        mResult = new GameResults();
        switch (key.getLetter()) {
            case ' ' -> { // Enter key
                if (currentGuess.length() == selectedWord.length()) {
                    System.out.println(currentGuess);
                    WordCheck.checkGuess(selectedWord, currentGuess, currentRound);
                    currentRound++;
                    currentGuess = "";
                }
            }
            case '\b' -> { // Delete key

                try {
                    currentGuess = currentGuess.substring(0, currentGuess.length() - 1);
                    mWindow.getGrid().getBox(currentRound, currentGuess.length()).setLetter(' ');
                } catch (Exception e) {
                    currentGuess = "";
                }
            }
            default -> { // Letter key
                if (currentGuess.length() < selectedWord.length()) {
                    currentGuess += key.getLetter();
                    mWindow.getGrid().getBox(currentRound, currentGuess.length() - 1).setLetter(key.getLetter());
                }
            }
        }
        if(currentRound == guessLimit) {
            mResult.unhidden();
        }

    }
    
//    public void endGame(int guessLimit) {
//        if(currentRound == guessLimit) {
//            mResult.unhidden();
//        }
//    }
    
    public String getCurrentGuess(){
        return currentGuess;
    }
}
