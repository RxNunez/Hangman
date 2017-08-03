import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Guest on 8/2/17.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean programRunning = true;

        WordBank rand = new WordBank();
        String gameWord = rand.randomWord();

        HangMan thisGame = new HangMan(gameWord);
        System.out.println("Hey, lets play Hangman!!!!");
        System.out.println("Here is your word!");
        int guesses = 0;

       while (programRunning) {
            try {
                System.out.println("Guess a letter!");
                System.out.println("******************");
                String input = bufferedReader.readLine().toLowerCase();
                if (input.equals(gameWord)) {
                    System.out.println("You win!!!!");
                    System.out.println(gameWord);
                    programRunning = false;
                    break;
                }
                if (!thisGame.containsLetter(input)) {
                    System.out.println("You suck!! Guess again!");
                }

                System.out.println("You have already guessed: " + thisGame.getGuessedLetters());

                if (thisGame.getWordAsArray().equals("finished")) {
                    System.out.println("Congratulations, you won!!! But you still stuck!");
                   System.out.println(thisGame.getGameWord());
                    programRunning = false;
                } else {
                    guesses ++;
                    if (guesses < 10) {
                        System.out.println(thisGame.getWordAsArray());
                        System.out.println("Guesses left: " + (10 - guesses));
                    } else {
                        System.out.println("You're out of guesses!");
                        programRunning = false;
                    }

                }
                System.out.println("******************");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}