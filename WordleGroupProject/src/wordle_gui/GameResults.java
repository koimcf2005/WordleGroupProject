/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle_gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import wordle_main.WordCheck;

/**
 *
 * @author Kayla Dixon
 */
public class GameResults extends JFrame implements ActionListener{
    private static WordCheck mResult;
    private final JButton endGameButton;
    private final JLabel guessLabel;
    private final JButton replayButton;
    private final JLabel userScore;
    private final JLabel winOrLose;
    
    public GameResults() {
        mResult = new WordCheck();
        winOrLose = new javax.swing.JLabel();
        userScore = new javax.swing.JLabel();
        guessLabel = new javax.swing.JLabel();
        replayButton = new javax.swing.JButton();
        endGameButton = new javax.swing.JButton();

        setSize(400, 340);
        setResizable(false);
        getContentPane().setBackground(new Color(18, 18, 19));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(false);

        winOrLose.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        winOrLose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        winOrLose.setText("Win or lose!");

        userScore.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        userScore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userScore.setText("String for how you did");

        guessLabel.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        guessLabel.setForeground(new java.awt.Color(0, 153, 51));
        guessLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guessLabel.setText("correct word - your guess");

        replayButton.setBackground(new java.awt.Color(0, 204, 51));
        replayButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        replayButton.setForeground(new java.awt.Color(255, 255, 255));
        replayButton.setText("Play Again?");

        endGameButton.setBackground(new java.awt.Color(153, 153, 153));
        endGameButton.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        endGameButton.setForeground(new java.awt.Color(0, 102, 0));
        endGameButton.setText("End Game");

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
    
    public void setWinOrLoseLabel() {
        if(mResult.getWin() == true) {
            winOrLose.setText("You Win!");
        }
        else {
            winOrLose.setText("You Lose!");
        }
    }
    
    public void setUserScoreLabel() {
        
    }
    
    public void setGuessLabel() {
        
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e) {
        if(mResult.getWin()== true) {
            
            System.out.println("you win");
        }
        else {
            System.out.println("you lose");
        }
    }
   
    
    public void unhidden() {
        setVisible(true);
        setAlwaysOnTop( true );
    }
    
    
    public void hidden() {
        setVisible(false);
    }
    
}