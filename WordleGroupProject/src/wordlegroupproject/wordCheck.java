/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordlegroupproject;

import wordlegroupproject.gui.Window;

/**
 *
 * @author andre
 */
public class wordCheck {
    private Window mWindow;
    
    public wordCheck(Window mWindow) {
        this.mWindow = mWindow;
    }
    
    public void checkGuess(String selectedWord, String guess, int guessCount){
        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.contains(Character.toString(guess.charAt(i)))) {
  //              mWindow.getGrid().getBox(guessCount, i).setAsWrongSpot();
                  System.out.print("R ");

            if (guess.charAt(i) == selectedWord.charAt(i)) {
//                    mWindow.getGrid().getBox(guessCount, i).setAsCorrectLetter();
                      System.out.print("P");
                }
                System.out.println("");
            } 
            
            else {
//                     mWindow.getGrid().getBox(guessCount, i).setAsIncorrectLetter();
                       System.out.println("W");
                }
        }
    }
}
