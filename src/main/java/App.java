import java.util.Random;
import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();
    Random randomGenerator = new Random();
    int wordCount = 23;
    Game newGame = new Game(randomGenerator.nextInt(wordCount));
    boolean gameNotOver = true;
    Integer guessLimit = 5;

    while (gameNotOver) {
      printMonster(newGame.wrongGuesses(), guessLimit);
      System.out.println("\n");
      System.out.println(newGame.getHiddenWord());
      System.out.println("Letters guessed: " + newGame.getLettersGuessed());
      System.out.println("Wrong Guesses: " + newGame.wrongGuesses() + "/" + guessLimit);
      String userGuess = console.readLine("Guess next letter: ");
      System.out.println("-----------------------------");
      if (!userGuess.equals("")) {
        newGame.guessLetter(userGuess.charAt(0));
      }

      if (newGame.getHiddenWord().indexOf('_') == -1) {
        System.out.println("\nYou Won!\tThe word was:\t" + newGame.getWord() + "!\n");
        String playAgain = console.readLine("Play again?\n");
        if (playAgain.equals("yes")) {
          console.flush();
          newGame = new Game(randomGenerator.nextInt(wordCount));
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

      if (newGame.wrongGuesses() == guessLimit) {
        printMonster(newGame.wrongGuesses(), guessLimit);
        System.out.println("You Lost!\tThe word was:\t" + newGame.getWord() + "!");
        String playAgain = console.readLine("Play again?\t");
        if (playAgain.equals("yes")) {
          console.flush();
          newGame = new Game(randomGenerator.nextInt(wordCount));
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

    }
  }

  public static void printMonster(int guesses, int limit) {
    String[] monster = {"######################~~..'|.##############.|`..~~#######################",
    "##############~./`.~~./' ./ ################ \\. `\\. ~~.`\\.~##############",
    "############~.' `.`-'   /   ~#############~ .  \\   `-'.'  `.~############",
    "##########~.'    |     |  .'\\ ~##########~ /`.  |     |     `.~##########",
    "########~.'      |     |  |`.`._ ~####~ _.'.'|  |     |       `.~########",
    "######~.'        `.    |  `..`._|\\.--./|_.'..'  |    .'         `.~######",
    "####~.'            \\   | #.`.`._`.'--`.'_.'.'.# |   /             `.~####",
    "##~.'       ......  \\  | ###.`~'(o\\||/o)`~'.### |  /  ......        `.~##",
    "~.`.......'~      `. \\  \\~####  |\\_  _/|  ####~/  / .'      ~`........'.~",
    ";.'                 \\ .----.__.'`(n||n)'`.__.----. /                  `; ",
    "`.                  .'    .'   `. \\`'/ .'   `.    `.                  .' ",
    "#:               ..':      :    '. ~~ .`    :      :`..               :# ",
    "#:             .'   :     .'     .'  `.     `.     :   `.             :# ",
    "#:           .'    .`   .'       . || .       `.   '.    `.           :# ",
    "#:         .'    .' :       ....'      `....       : `.    `.         :# ",
    "#:       .'    .' ) )        (      )     (      (    )`.    `.       :# ",
    "#:     ..'    .  ( ((   )  ) )) (  ((  (  ))  )  ))  ((  `.   `..     :# ",
    "#:  ..'      .'# ) ) ) (( ( ( (  ) ) ) ))( ( (( ( (  ) ) #`.     `..  :# ",
    "#;.'        .'##|((  ( ) ) ) ) )( (  (( ( ) )) ) ) )( (||##`.       `.:# ",
    "#`.        .'###|\\__  )( (( ( ( )  )  )) )  (  (( ( )_)/|###`.       .'# ",
    "##.`       '#####\\__~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~__/#####`      '.## ",
    "###        #######  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  #######       ### "};

    System.out.print("\033[H\033[2J");
    for (int i = 0; i < guesses * monster.length/limit; i++) {
      System.out.println(monster[i]);
    }
  }
}
