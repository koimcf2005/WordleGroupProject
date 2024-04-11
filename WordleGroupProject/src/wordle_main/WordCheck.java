package wordle_main;

import wordle_gui.Window;

/**
 * @author andre
 */
public class WordCheck {

    private Window mWindow;

    public WordCheck(Window mWindow) {
        this.mWindow = mWindow;
    }

    public void checkGuess(String selectedWord, String guess, int guessCount) {
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.contains(Character.toString(guess.charAt(i)))) {
                mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();
                System.out.print("R ");

                if (guess.charAt(i) == selectedWord.charAt(i)) {
                    mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                    System.out.print("P");
                }
                System.out.println("");
            } else {
                mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                System.out.println("W");
            }
        }
    }
}
