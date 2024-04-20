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

    /*
    getCount is a method that allows for a quick way to find occurences of a 
    character in a specified string
    */
    private static int getCount(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    /*
    checkGuess runs through a given guess string and compares it to the selected
    word for the current wordle game and alters the gui based on the presence of
    included letters(in the right place or misplaced) as well as incorrect letters
    */
    public static void checkGuess(String selectedWord, String guess, int guessCount) {
        //Allows for data to flow to the GameResults class
        mResult = new GameResults();
        //Converts the guess from all caps to lowercase for easier evaluation
        String lowGuess = guess.toLowerCase();

        //Checks for a correct guess and triggers a win
        if (lowGuess.compareTo(selectedWord) == 0) {
            hasWon = true;
            mResult.unhidden(selectedWord);
            for (int i = 0; i < selectedWord.length(); i++) {
                mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
            }
        } 
        
        //if the guess is not identical it begins to evaluate the guess' accuracy
        else {
            //loops through the entire guess and answer character by character
            for (int i = 0; i < selectedWord.length(); i++) {

                //Variables to streamline checking guesses
                char currentLetter = lowGuess.charAt(i);
                int guessNum = WordCheck.getCount(lowGuess, currentLetter);
                int answerNum = WordCheck.getCount(selectedWord, currentLetter);
                
                /*
                This first if evaluates for multiple of the same letter in the 
                guess when there are only one of said letter in the answer 
                allowing for the output to not mislead the user into thinking 
                that there is a double letter when there is not
                */
                if ((guessNum > 1) && !(answerNum > 1) ){
                    
                    System.out.println(currentLetter + " appears twice!");
                    
                    int secondLetter = lowGuess.indexOf(currentLetter, i + 1);
                    System.out.println("index of second " + currentLetter + 
                            " is " + secondLetter);
                    
                    StringBuilder modGuess = new StringBuilder(lowGuess);
                    modGuess.setCharAt(secondLetter, ' ');
                    
                    if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                        lowGuess = modGuess.toString();
                        System.out.println("mod: " + modGuess);
                    } 
                    else {
                        lowGuess = lowGuess.replaceFirst(Character.toString(currentLetter), " ");
                    }
                    System.out.println("after check: " + lowGuess);    
                }

                /*
                The if/else below checks for if the current letter is in the 
                answer and then if it is in the right posistion
                */
                if (selectedWord.contains(Character.toString(lowGuess.charAt(i)))) {
                    mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();

                    if (lowGuess.charAt(i) == selectedWord.charAt(i)) {
                        mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                    }
                    
                    mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsNormal();
                } 
                
                else {
                    mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                    
                    if(lowGuess.charAt(i) != ' '){
                        mWindow.getKeyboard().getButtonByText(Character.toString(guess.charAt(i))).setAsGrey();
                    }
                }
            }
        }

    }

    //Getters and setters allowing for outside manipulation
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
