/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WordSelection;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
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
            // load data from file 1
            String threeWord = System.getProperty("user.dir");
            fileInStream1 = new FileInputStream (threeWord 
                    + "\\src\\WordSelection\\3-LetterWords.txt");
            System.out.println("Opened file one");
            fileScanner1 = new Scanner(fileInStream1);
            
            String fourWord = System.getProperty("user.dir");
            fileInStream2 = new FileInputStream (fourWord 
                    + "\\src\\WordSelection\\4-LetterWords.txt");
            System.out.println("Opened file two");
            fileScanner2 = new Scanner(fileInStream2);
            
            String fiveWord = System.getProperty("user.dir");
            fileInStream3 = new FileInputStream (fiveWord 
                    + "\\src\\WordSelection\\5-LetterWords.txt");
            System.out.println("Opened file three");
            fileScanner3 = new Scanner(fileInStream3);
            
            String sixWord = System.getProperty("user.dir");
            fileInStream4 = new FileInputStream (sixWord 
                    + "\\src\\WordSelection\\6-LetterWords.txt");
            System.out.println("Opened file four");
            fileScanner4 = new Scanner(fileInStream4);
            
            String sevenWord = System.getProperty("user.dir");
            fileInStream5 = new FileInputStream (sevenWord 
                    + "\\src\\WordSelection\\7-LetterWords.txt");
            System.out.println("Opened file five");
            fileScanner5 = new Scanner(fileInStream5);

            //read entire line as string for each file
            String line1 = fileScanner1.nextLine();
            //String line2 = bf2.readLine();
            //String line3 = bf3.readLine();
            //String line4 = bf4.readLine();
            //String line5 = bf5.readLine();

            // checking for end of files
            while (line1 != null) {
                threeLetterWords.add(line1);
                line1 = fileScanner1.nextLine();
            }

//            while (line2 != null) {
//                fourLetterWords.add(line2);
//                line2 = bf2.readLine();
//            }
//
//            while (line3 != null) {
//                fiveLetterWords.add(line3);
//                line3 = bf3.readLine();
//            }
//
//            while (line4 != null) {
//                sixLetterWords.add(line4);
//                line4 = bf4.readLine();
//            }
//
//            while (line5 != null) {
//                sevenLetterWords.add(line5);
//                line5 = bf5.readLine();
//            }
            
            

//            // closing bufferreader objects
//            bf1.close();
//            bf2.close();
//            bf3.close();
//            bf4.close();
//            bf5.close();
            
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }

        // storing the data in arraylist to array
        //String[] array1
            //= threeLetterWords.toArray(new String[0]);

        // printing each line of file 
        // which is stored in array
        for (String str : threeLetterWords) {
            System.out.println(str);
        }
    }
    
    public String RandomWord(int wordList) {
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
