/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordlegroupproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SavageGoddess
 */
public class WordSelection {
    //word list initialization
    List<String> threeLetterWords
            = new ArrayList<>();
    List<String> fourLetterWords
                = new ArrayList<>();
    List<String> fiveLetterWords
                = new ArrayList<>();
    List<String> sixLetterWords
                = new ArrayList<>();
    List<String> sevenLetterWords
                = new ArrayList<>();
        
    public void listExtraction() throws Exception{
        List<String> threeLetterWords
            = new ArrayList<>();
        List<String> fourLetterWords
                = new ArrayList<>();
        List<String> fiveLetterWords
                = new ArrayList<>();
        List<String> sixLetterWords
                = new ArrayList<>();
        List<String> sevenLetterWords
                = new ArrayList<>();

        // load data from file
        BufferedReader bf = new BufferedReader(
        new FileReader("3LetterWords.txt"));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            threeLetterWords.add(line);
            line = bf.readLine();
        }

        // closing bufferreader object
        bf.close();

        // storing the data in arraylist to array
        String[] array
            = threeLetterWords.toArray(new String[0]);

        // printing each line of file 
        // which is stored in array
        for (String str : array) {
            System.out.println(str);
        }
    }
    
    //list initialization
    

}
