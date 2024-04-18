package wordle_main;

import wordle_gui.GameResults;
import wordle_gui.Window;

/**
 * @author andre
 */
public class WordCheck {
    
   private static boolean hasWon = false;
    
    private static Window mWindow = WordleGroupProject.mWindow;
    private static GameResults mResult;

    public static void checkGuess(String selectedWord, String guess, int guessCount) {
        mResult = new GameResults();
        String lowGuess = guess.toLowerCase();
        
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.contains(Character.toString(lowGuess.charAt(i)))) {
                mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();

                if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                    mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                }
            } else {
                mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsGrey();   
            }
        }
        if(lowGuess.compareTo(selectedWord)== 0){
            hasWon = true;
            mResult.unhidden();
            
        }
        mResult.unhidden();
    }
    
    public boolean getWin(){
        return hasWon;
    }
    
}
