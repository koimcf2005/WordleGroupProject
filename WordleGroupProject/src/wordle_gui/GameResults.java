package wordle_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import wordle_main.FinalScore;
import wordle_main.WordCheck;
import wordle_main.WordleGroupProject;


/**
 *
 * @author Kayla
 */
public class GameResults extends JFrame implements ActionListener{
    private static FinalScore mFinal;
    private static WordCheck mCheck;
    private final JButton endGameButton;
    private final JLabel guessLabel;
    private final JButton replayButton;
    private final JLabel userScore;
    private final JLabel winOrLose;
    
    //gui generation for the end game screen
    public GameResults() {
        winOrLose = new javax.swing.JLabel();
        userScore = new javax.swing.JLabel();
        guessLabel = new javax.swing.JLabel();
        replayButton = new javax.swing.JButton();
        endGameButton = new javax.swing.JButton();
        mFinal = new FinalScore();
        mCheck = new WordCheck();
        
        replayButton.addActionListener(this);
        endGameButton.addActionListener(this);

        setSize(400, 400); //340
        setResizable(false);
        getContentPane().setBackground(new Color(18, 18, 19));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(false);

        winOrLose.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        winOrLose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winOrLose.setForeground(new Color(255, 255, 255));
        winOrLose.setText("Win or lose!");
        winOrLose.setFocusable(false);

        userScore.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        userScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userScore.setForeground(new Color(255, 255, 255));
        userScore.setText("String for how you did");
        userScore.setFocusable(false);

        guessLabel.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        guessLabel.setForeground(new java.awt.Color(255, 204, 0));
        guessLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guessLabel.setText("correct word - your guess");
        guessLabel.setFocusable(false);

        replayButton.setBackground(new java.awt.Color(83, 141, 78));
        replayButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        replayButton.setForeground(new java.awt.Color(255, 255, 255));
        replayButton.setText("Play Again?");
        replayButton.setFocusable(false);
        replayButton.setBorderPainted(false);

        endGameButton.setBackground(new java.awt.Color(129, 131, 132));
        endGameButton.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        endGameButton.setForeground(new java.awt.Color(255, 255, 255));
        endGameButton.setText("End Game");
        endGameButton.setFocusable(false);
        endGameButton.setBorderPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(guessLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(userScore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(winOrLose, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(replayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endGameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(winOrLose, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(guessLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userScore, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(replayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
       
    }
    
    public JButton replayButton() {
        return replayButton;
    }
    
    public JButton endGameButton() {
        return endGameButton;
    }
    
    //changes the label for if they win or lose
    public void setWinOrLoseLabel(boolean win) {
        if(win == true) {
            winOrLose.setText("You Win!");
        }
        else {
            winOrLose.setText("You Lose!");
        }
        
        
    }
    
    //Shows the answer
    public void setGuessLabel(String answer) {
        guessLabel.setText("The word was " + answer.toUpperCase());
    }
    
    //shows the final score string and makes the end game button visible
    public void unhidden(String selectedWord) {
        String line;
        
        line = mFinal.displayFinalScore();
        
        userScore.setText(line);
        
        setWinOrLoseLabel(mCheck.getWin());
        setGuessLabel(selectedWord);
        
        setVisible(true);
        setAlwaysOnTop( true );
    }
    
    
    //hides the end game button
    public void hidden() {
        setVisible(false);
    }
    
    @Override
    //ends the game or restarts it based on what the player presses
    public void actionPerformed(ActionEvent a) {
        if(a.getSource() == replayButton) {
            hidden();
            WordleGroupProject.getWindow().dispose();
            WordleGroupProject.gameRestart();
        }
        else if(a.getSource() == endGameButton) {
            System.exit(0);
        }
    } 
}
