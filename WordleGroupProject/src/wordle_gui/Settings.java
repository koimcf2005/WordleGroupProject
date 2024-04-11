package wordle_gui;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * @author koimc
 */
public class Settings {
    private final JFrame window;
    private final JLabel titleLabel;
    private final JButton guessCountButton0;
    private final JButton guessCountButton1;
    private final JLabel guessCountLabel;
    private final JButton wordLengthButton0;
    private final JButton wordLengthButton1;
    private final JLabel wordLengthLabel;
    private final JButton startButton;
    
    public Settings(JFrame window, ActionListener listener) {
        this.window = window;
        titleLabel = new JLabel();
        wordLengthButton0 = new JButton();
        wordLengthButton1 = new JButton();
        wordLengthLabel = new JLabel();
        guessCountButton0 = new JButton();
        guessCountButton1 = new JButton();
        guessCountLabel = new JLabel();
        startButton = new JButton();
        
        titleLabel.setFont(new Font("Verdana", 1, 36)); // NOI18N
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setText("Wordle");
        titleLabel.setVerticalAlignment(SwingConstants.TOP);
        titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(102, 102, 102)));
        
        wordLengthButton0.setFont(new Font("Verdana", 1, 36)); // NOI18N
        wordLengthButton0.setBackground(new Color(129, 131, 132));
        wordLengthButton0.setForeground(new Color(255, 255, 255));
        wordLengthButton0.setText("<");
        wordLengthButton0.setFocusable(false);
        wordLengthButton0.setBorderPainted(false);
        wordLengthButton0.addActionListener(listener);

        wordLengthButton1.setFont(new Font("Verdana", 1, 36)); // NOI18N
        wordLengthButton1.setBackground(new Color(129, 131, 132));
        wordLengthButton1.setForeground(new Color(255, 255, 255));
        wordLengthButton1.setText(">");
        wordLengthButton1.setFocusable(false);
        wordLengthButton1.setBorderPainted(false);
        wordLengthButton1.addActionListener(listener);

        wordLengthLabel.setFont(new Font("Verdana", 1, 18)); // NOI18N
        wordLengthLabel.setForeground(new Color(255, 255, 255));
        wordLengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLengthLabel.setText("Word Length: 5");

        guessCountButton0.setFont(new Font("Verdana", 1, 36)); // NOI18N
        guessCountButton0.setBackground(new Color(129, 131, 132));
        guessCountButton0.setForeground(new Color(255, 255, 255));
        guessCountButton0.setText("<");
        guessCountButton0.setFocusable(false);
        guessCountButton0.setBorderPainted(false);
        guessCountButton0.addActionListener(listener);
        
        guessCountButton1.setFont(new Font("Verdana", 1, 36)); // NOI18N
        guessCountButton1.setBackground(new Color(129, 131, 132));
        guessCountButton1.setForeground(new Color(255, 255, 255));
        guessCountButton1.setText(">");
        guessCountButton1.setFocusable(false);
        guessCountButton1.setBorderPainted(false);
        guessCountButton1.addActionListener(listener);
        
        guessCountLabel.setFont(new Font("Verdana", 1, 18)); // NOI18N
        guessCountLabel.setForeground(new Color(255, 255, 255));
        guessCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        guessCountLabel.setText("Guess Count: 7");

        startButton.setBackground(new Color(83, 141, 78));
        startButton.setFont(new Font("Verdana", 1, 24)); // NOI18N
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setText("Start!");
        startButton.setBorderPainted(false);
        startButton.setFocusable(false);
        startButton.addActionListener(listener);
        
        GroupLayout layout = new GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(wordLengthLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(guessCountLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(startButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guessCountButton0, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(guessCountButton1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wordLengthButton0, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(wordLengthButton1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(titleLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(wordLengthLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(wordLengthButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(wordLengthButton0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(guessCountLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(guessCountButton1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(guessCountButton0, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(startButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        
    }

    public JButton getGuessCountButton0() {
        return guessCountButton0;
    }

    public JButton getGuessCountButton1() {
        return guessCountButton1;
    }

    public JButton getWordLengthButton0() {
        return wordLengthButton0;
    }

    public JButton getWordLengthButton1() {
        return wordLengthButton1;
    }
    
    public JButton getStartButton() {
        return startButton;
    }
    
    public void setWordLengthLabel(int newLength) {
        wordLengthLabel.setText("Word Length: " + newLength);
    }
    
    public void setGuessCountLabel(int newCount) {
        guessCountLabel.setText("Guess Count: " + newCount);
    }
    
    public void show() {
        titleLabel.setVisible(true);
        wordLengthButton0.setVisible(true);
        wordLengthButton1.setVisible(true);
        wordLengthLabel.setVisible(true);
        guessCountButton0.setVisible(true);
        guessCountButton1.setVisible(true);
        guessCountLabel.setVisible(true);
        startButton.setVisible(true);
    }
    
    public void hide() {
        titleLabel.setVisible(false);
        wordLengthButton0.setVisible(false);
        wordLengthButton1.setVisible(false);
        wordLengthLabel.setVisible(false);
        guessCountButton0.setVisible(false);
        guessCountButton1.setVisible(false);
        guessCountLabel.setVisible(false);
        startButton.setVisible(false);
    }
}
