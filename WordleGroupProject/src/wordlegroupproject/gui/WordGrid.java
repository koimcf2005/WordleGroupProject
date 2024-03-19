package wordlegroupproject.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author koimc
 */
public class WordGrid extends JPanel {
    
    private final int wordLength;
    private final int guessCount;
    private final JFrame window;
    private ArrayList<LetterBox> mGrid = new ArrayList<>();
    
    public WordGrid(int wordLength, int guessCount, JFrame window) {
        this.wordLength = wordLength;
        this.guessCount = guessCount;
        this.window = window;
                
        // Sets the grid layout default settings
        GridLayout layout = new GridLayout(guessCount, wordLength);
        layout.setHgap(5);
        layout.setVgap(5);
        
        // Greates layout and makes background invisible
        setLayout(layout);
        setBackground(new Color(0, 0, 0, 0));
  
        // Creates the boxes
        for (int i = 0; i < guessCount; i++) {
            for (int j = 0; j < wordLength; j++) {
                LetterBox newBox = new LetterBox();
                newBox.setSize(new Dimension(60, 60));
                mGrid.add(newBox);
                add(newBox);
            }
        }
    }
    
    public void calculateBounds(int wordLength, int guessCount) {
        int X = 30 + (7 - wordLength) * 33;
        int Y = 15;
        int W = (60 * wordLength) + (5 * (wordLength - 1));
        int H = (60 * guessCount) + (5 * (guessCount - 1));
        
        setBounds(X, Y, W, H);
    }
    
    public LetterBox getBox(int row, int column) {
        LetterBox retBox = null;
        int index = (row * wordLength) + column;
        
        if (row > guessCount - 1 || column > wordLength - 1)
            return null;
        else
            return mGrid.get(index);
    }
    
    @Override
    public void hide() {
        for (int box = 0; box < mGrid.size(); box++) {
            mGrid.get(box).setVisible(false);
        }
    }
    
    @Override
    public void show() {
        for (int box = 0; box < mGrid.size(); box++) {
            mGrid.get(box).setVisible(true);
        }
    }
    
}
