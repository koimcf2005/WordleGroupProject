package wordle_word_selection;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
  * @author Kayla Dixon
 */
public class WordSelection {
    //word list initialization
    List<String> threeLetterWords = new ArrayList<>();
    List<String> fourLetterWords = new ArrayList<>();
    List<String> fiveLetterWords = new ArrayList<>();
    List<String> sixLetterWords = new ArrayList<>();
    List<String> sevenLetterWords = new ArrayList<>();
        
    public void listExtraction() {
        FileInputStream fileInStream1;
        FileInputStream fileInStream2;
        FileInputStream fileInStream3;
        FileInputStream fileInStream4;
        FileInputStream fileInStream5;
        Scanner fileScanner1;
        Scanner fileScanner2;
        Scanner fileScanner3;
        Scanner fileScanner4;
        Scanner fileScanner5;
        
        try {
            // load data from files
            String threeWord = System.getProperty("user.dir");
            fileInStream1 = new FileInputStream (threeWord 
                    + "\\src\\wordle_word_selection\\3-LetterWords.txt");
            //System.out.println("Opened file one");
            fileScanner1 = new Scanner(fileInStream1);
            
            String fourWord = System.getProperty("user.dir");
            fileInStream2 = new FileInputStream (fourWord 
                    + "\\src\\wordle_word_selection\\4-LetterWords.txt");
            //System.out.println("Opened file two");
            fileScanner2 = new Scanner(fileInStream2);
            
            String fiveWord = System.getProperty("user.dir");
            fileInStream3 = new FileInputStream (fiveWord 
                    + "\\src\\wordle_word_selection\\5-LetterWords.txt");
            //System.out.println("Opened file three");
            fileScanner3 = new Scanner(fileInStream3);
            
            String sixWord = System.getProperty("user.dir");
            fileInStream4 = new FileInputStream (sixWord 
                    + "\\src\\wordle_word_selection\\6-LetterWords.txt");
            //System.out.println("Opened file four");
            fileScanner4 = new Scanner(fileInStream4);
            
            String sevenWord = System.getProperty("user.dir");
            fileInStream5 = new FileInputStream (sevenWord 
                    + "\\src\\wordle_word_selection\\7-LetterWords.txt");
            //System.out.println("Opened file five");
            fileScanner5 = new Scanner(fileInStream5);

            // checking for end of files and putting them in their arrays
            while (fileScanner1.hasNextLine()) {
                threeLetterWords.add(fileScanner1.nextLine());
            }
            
            while (fileScanner2.hasNextLine()) {
                fourLetterWords.add(fileScanner2.nextLine());
            }

            while (fileScanner3.hasNextLine()) {
                fiveLetterWords.add(fileScanner3.nextLine());
            }
            while (fileScanner4.hasNextLine()) {
                sixLetterWords.add(fileScanner4.nextLine());
            }
            while (fileScanner5.hasNextLine()) {
                sevenLetterWords.add(fileScanner5.nextLine());
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        //this can be used to print an array to make sure they are not empty
        //you can just change the array to run it for
        //leave it commented out unless you want to test it
        //for (String str : sevenLetterWords) {
        //    System.out.println(str);
        //}
    }
    
    public String randomWord(int wordList) {
        String currentWord = "Not working";
        
        switch(wordList){
            
            case 3 -> {
                int index = (int)(Math.random() * threeLetterWords.size());
            
                currentWord = threeLetterWords.get(index);
            }
            case 4 -> {
                int index2 = (int)(Math.random() * fourLetterWords.size());
            
                currentWord = fourLetterWords.get(index2);
            }
            case 5 -> {
                int index3 = (int)(Math.random() * fiveLetterWords.size());
            
                currentWord = fiveLetterWords.get(index3);
            }
            case 6 -> {
                int index4 = (int)(Math.random() * sixLetterWords.size());
            
                currentWord = sixLetterWords.get(index4);
            }
            case 7 -> {
                int index5 = (int)(Math.random() * sevenLetterWords.size());
            
                currentWord = sevenLetterWords.get(index5);
            }
        }
        return currentWord;
    }
}
