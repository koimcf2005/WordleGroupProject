package wordle_main;

import wordle_gui.InputButton;
import wordle_gui.Window;

/**
 * @author andre
 */
public class UserLetters {
    // Object variables
    private Window mWindow = WordleGroupProject.mWindow;
    // Primitive variables
    public static String currentGuess = "";
    public static int currentRound = 0;

    public void getKeyboardInput(InputButton key, String selectedWord) {
        switch (key.getLetter()) {
            case ' ' -> { // Enter key
                if (currentGuess.length() == selectedWord.length()) {
                    System.out.println(currentGuess);
                    currentGuess = "";
                    currentRound++;
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
    }
}
