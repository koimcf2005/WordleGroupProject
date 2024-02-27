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
        GridLayout layout = new GridLayout(wordLength, guessCount);
        layout.setHgap(5);
        layout.setVgap(5);
        
        // Greates layout and makes background invisible
        setLayout(layout);
        setBackground(new Color(0, 0, 0, 0));
  
        // Creates the boxes
        for (int i = 0; i < wordLength; i++) {
            for (int j = 0; j < guessCount; j++) {
                LetterBox newBox = new LetterBox();
                newBox.setSize(new Dimension(10, 10));
                mGrid.add(newBox);
                add(newBox);
            }
        }
    }
    
    public LetterBox getBoxFromIndex(int index) {
        LetterBox retBox = null;
        if (index < mGrid.size()) {
            retBox = mGrid.get(index);
        }
        return retBox;
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
