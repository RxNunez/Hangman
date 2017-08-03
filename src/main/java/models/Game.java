package models;
import java.util.Random;
/**
 * Created by Guest on 8/2/17.
 */
//public class Game {
//
//    private char answer;
//    private char guessed;
//    private String words[]
//}
public class HangMan {
    private String gameWord;
    private String wordInProgress;
    private char[] wordAsArray;
    List<String> guessedLetters =  new ArrayList<String>();

    public HangMan(String gameWord) {
        this.gameWord = gameWord;
        wordInProgress = gameWord.replaceAll( "[a-zA-Z]","_" );
        wordAsArray = wordInProgress.toCharArray();
    }
    public boolean containsLetter(String input) {
        if (guessedLetters.contains(input) ) {
            return false;
        } else {
            guessedLetters.add(input);
            changeLetters(input);
            return true;
        }
    }
    public void changeLetters(String input) {
        char inputChar = input.charAt(0);
        for (int i = 0; i < gameWord.length(); i++) {
            if (gameWord.charAt(i) == inputChar) {
                wordAsArray[i] = inputChar;
            }
        }
    }
  public class WordBank {

        Random random = new Random();

        String[] bank = {"homies","pickles","juice","oranges","grapes"};

        public String randomWord() {
            String randomWord = bank[random.nextInt(5)];
            return randomWord;
        }
    }
    //GETTERS
    public String getGameWord() {
        return gameWord;
    }
    public String getWordInProgress() {
        return wordInProgress;
    }
    public String getWordAsArray() {
        String output = new String(wordAsArray);
        if (output.contains("_")) {
            return output;
        } else {
            return "finished";
        }
    }
    public List<String> getGuessedLetters() {
        return guessedLetters;
    }

}