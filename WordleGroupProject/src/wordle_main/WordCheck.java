package wordle_main;

import wordle_gui.GameResults;
import wordle_gui.Window;

/**
 * @author Andrew
 */
public class WordCheck {

    private static boolean hasWon = false;

    private static Window mWindow = WordleGroupProject.getWindow();
    private static GameResults mResult;

    private static int getCount(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static void checkGuess(String selectedWord, String guess, int guessCount) {
        mResult = new GameResults();
        String lowGuess = guess.toLowerCase();

        if (lowGuess.compareTo(selectedWord) == 0) {
            hasWon = true;
            mResult.unhidden();
            mResult.setWinOrLoseLabel(hasWon);
            mResult.setGuessLabel(selectedWord, guess);
            for (int i = 0; i < selectedWord.length(); i++) {
                mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
            }
        } 
        else {
            for (int i = 0; i < selectedWord.length(); i++) {

                char currentLetter = lowGuess.charAt(i);
                //System.out.println(currentLetter);
                //System.out.println(checkGuess);
                if ((WordCheck.getCount(lowGuess, currentLetter) > 1) && !(WordCheck.getCount(selectedWord, currentLetter) > 1) ){
                    System.out.println(currentLetter + " appears twice!");
                    int secondLetter = lowGuess.replace(currentLetter, ' ').indexOf(Character.toString(currentLetter)) + 1;
                    StringBuilder modGuess = new StringBuilder(lowGuess);
                    modGuess.setCharAt(secondLetter, ' ');
                    //System.out.println("made it to here");
                    if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                        lowGuess = modGuess.toString();
                        //System.out.println("First Was Right, now: " + lowGuess);
                    } 
                    else {
                        lowGuess = lowGuess.replaceFirst(Character.toString(currentLetter), " ");
                        //System.out.println("Second was better: " + lowGuess);
                    }
                }

                if (selectedWord.contains(Character.toString(lowGuess.charAt(i)))) {
                    mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();

                    if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                        mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                    }
                    mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsNormal();
                } 
                
                else {
                    mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                    if(!(WordCheck.getCount(lowGuess, currentLetter) > 1)){
                        mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsGrey();
                    }
                }
            }
        }

    }

    public static boolean getWin() {
        return hasWon;
    }

    public static void setHasWon(boolean bool) {
        hasWon = bool;
    } 
    
    public static void setWindow(Window window) {
        mWindow = window;
    }
}
