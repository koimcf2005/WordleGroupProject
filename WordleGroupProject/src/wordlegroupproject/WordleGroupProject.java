package wordlegroupproject;

import wordlegroupproject.gui.InputButton;
import wordlegroupproject.gui.Window;

/**
 * This is the main class
 * 
 * @author Koi McFarland
 * @author Andrew Burbage
 * @author Kayla Dixon
 */
public class WordleGroupProject {
    // Temp variable
    private static String mWord = "";
    
    public static void main(String[] args) {
        
        /**
         * Window has two different parts, the grid and the keyboard.
         * 
         * You can change aspects of the grid in the following ways:
         *      window.getGrid().getBoxFromIndex(index).setAsCorrectLetter();
         *      window.getGrid().getBoxFromIndex(index).setAsEmpty();
         *      window.getGrid().getBoxFromIndex(index).setAsIncorrectLetter();
         *      window.getGrid().getBoxFromIndex(index).setAsWrongSpot();
         *      window.getGrid().getBoxFromIndex(index).setLetter('char');
         *      window.getGrid().hide();
         *      window.getGrid().show();
         * 
         * You can use aspects of the keyboard in the following ways:
         *      window.getKeyboard().getButtonCount();
         *      window.getKeyboard().getButtonByIndex(index);
         *      window.getKeyboard().getButtonByText(string);
         *      window.getKeyboard().getButtonByText(string).setAsGrey();
         *      window.getKeyboard().getButtonByText(string).setAsNormal();
         *      window.getKeyboard().hide();
         *      window.getKeyboard().show();
         */
        Window window = new Window();
        
        // TODO: Any functionality
    }
    
   /**
    * This function gets all input from the Window class.
    * @param input The InputButton that has been clicked
    * @author Koi McFarland
    */
    public static void getInput(InputButton input) {
        // TODO: add real functionality

        // Just testing to make sure it works
        mWord += input.getLetter();
        System.out.println(mWord);
    }
}
