package wordle_main;

import wordle_gui.Window;

/**
 * @author andre
 */
public class WordCheck {
    // Object variables
    private Window mWindow = WordleGroupProject.mWindow;

    public void checkGuess(String selectedWord, String guess, int guessCount) {
        
        String lowGuess = guess.toLowerCase();
        
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.contains(Character.toString(lowGuess.charAt(i)))) {
                mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();
                //System.out.print("R ");

                if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                    mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                    //System.out.print("P");
                }
                System.out.println("");
            } else {
                mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsGrey();
                //System.out.println("W");
            }
        }
    }
}
