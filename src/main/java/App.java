import java.util.Random;
import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();
    Random randomGenerator = new Random();
    int index = randomGenerator.nextInt(1); //number needs to be length of arrayWords in Game.java

    boolean gameNotOver = true;
    Game newGame = new Game(index);

    while (gameNotOver) {
      System.out.println(newGame.getWord());
      System.out.println("Letters guessed: " + newGame.getLettersGuessed());
      System.out.println("Guess next letter");
      char userGuess = console.readLine().charAt(0);
      newGame.guessLetter(userGuess);

    }
  }
}
