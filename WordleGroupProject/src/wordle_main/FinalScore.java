package wordle_main;

/**
 * @author Kayla Dixon
 */
public class FinalScore {
    private String label;
    private UserLetters mUserLetters;
    
    public String displayFinalScore(){
        mUserLetters = new UserLetters();
                
        if(WordCheck.getWin() == true) {
            int finalRound = mUserLetters.getCurrentRound() + 1;
            switch(finalRound) {
                case 1 -> {
                    label = "You seem like a Cheater.";
                }
                case 2 -> {
                    label = "I smell foul play.";
                }
                case 3 -> {
                    label = "You were just lucky.";
                }
                case 4 -> {
                    label = "I guess you did well.";
                }
                case 5 -> {
                    label = "You think you're so cool.";
                }
                case 6 -> {
                    label = "You cut it real close there.";
                }
                case 7 -> {
                    label = "It's a miracle!";
                }
            }
        }
        else {
            int finalRound = mUserLetters.getCurrentRound();
            switch(finalRound) {
                case 3 -> {
                    label = "You should have known.";
                }
                case 4 -> {
                    label = "Too good to be true.";
                }
                case 5 -> {
                    label = "It's okay to suck.";
                }
                case 6 -> {
                    label = "Do better.";
                }
                case 7 -> {
                    label = "Maybe try another game.";
                }
            }
        }
        return label;
    }
}


