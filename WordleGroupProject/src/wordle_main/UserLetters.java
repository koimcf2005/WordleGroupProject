package wordle_main;

import wordle_gui.InputButton;
import wordle_gui.Window;

/**
 * @author andre
 */
public class UserLetters {
    
    public static String currentGuess = "";
    
     private Window mWindow;

    public UserLetters(Window mWindow) {
        this.mWindow = mWindow;
    }
    
    public void getKeyboardInput(InputButton key, int guessCount, String selectedWord) {
        
            switch (key.getLetter()) {
                case ' ' -> { // Enter key
                    if(currentGuess.length()== selectedWord.length()){
                        System.out.println(currentGuess);
                        currentGuess = "";
                    }
                    
                }
                case '\b' -> { // Delete key
                  
                     try{
                         currentGuess = currentGuess.substring(0, currentGuess.length() - 1);
                         mWindow.getGrid().getBox(guessCount, currentGuess.length()).setLetter(' ');
                     }
                     catch(Exception e){
                         currentGuess = "";
                     }
                }
                default -> { // Letter key
                    if(currentGuess.length() < selectedWord.length()){
                        currentGuess += key.getLetter();
                        mWindow.getGrid().getBox(guessCount, currentGuess.length()-1).setLetter(key.getLetter());
                    }
                }
            }
        //}
    }
}
