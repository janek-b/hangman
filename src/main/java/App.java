import java.util.Random;
import java.io.Console;

public class App {
  public static void main(String[] args) {
    Console console = System.console();
    Game newGame = startNewGame();
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
        printMonster(newGame.wrongGuesses(), guessLimit);
        System.out.println("\nYou Won!\tThe word was:\t" + newGame.getWord() + "!\n");
        String playAgain = console.readLine("Play again?\n");
        if (playAgain.equals("yes")) {
          newGame = startNewGame();
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

      if (newGame.wrongGuesses() == guessLimit) {
        printMonster(newGame.wrongGuesses(), guessLimit);
        System.out.println("You Lost!\tThe word was:\t" + newGame.getWord() + "!");
        String playAgain = console.readLine("Play again?\t");
        if (playAgain.equals("yes")) {
          newGame = startNewGame();
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

    }
  }

  public static Game startNewGame() {
    Console console = System.console();
    Random randomGenerator = new Random();
    System.out.print("\033[H\033[2J");
    System.out.println("___   ___   ________   ___   __    _______    ___ __ __   ________   ___   __ ");
    System.out.println("/__/\\ /__/\\ /_______/\\ /__/\\ /__/\\ /______/\\  /__//_//_/\\ /_______/\\ /__/\\ /__/\\");
    System.out.println("\\::\\ \\\\  \\ \\\\::: _  \\ \\\\::\\_\\\\  \\ \\\\::::__\\/__\\::\\| \\| \\ \\\\::: _  \\ \\\\::\\_\\\\  \\ \\");
    System.out.println("\\::\\/_\\ .\\ \\\\::(_)  \\ \\\\:. `-\\  \\ \\\\:\\ /____/\\\\:.      \\ \\\\::(_)  \\ \\\\:. `-\\  \\ \\");
    System.out.println(" \\:: ___::\\ \\\\:: __  \\ \\\\:. _    \\ \\\\:\\\\_  _\\/ \\:.\\-/\\  \\ \\\\:: __  \\ \\\\:. _    \\ \\");
    System.out.println("  \\: \\ \\\\::\\ \\\\:.\\ \\  \\ \\\\. \\`-\\  \\ \\\\:\\_\\ \\ \\  \\. \\  \\  \\ \\\\:.\\ \\  \\ \\\\. \\`-\\  \\ \\");
    System.out.println("   \\__\\/ \\::\\/ \\__\\/\\__\\/ \\__\\/ \\__\\/ \\_____\\/   \\__\\/ \\__\\/ \\__\\/\\__\\/ \\__\\/ \\__\\/");
    String stringDifficulty = console.readLine("\nChoose difficulty: Easy, Medium, Hard\n").toLowerCase();
    int intDiff = 0;
    switch (stringDifficulty) {
      case "easy": intDiff = 0;
        break;
      case "medium": intDiff = 1;
        break;
      case "hard": intDiff = 2;
        break;
    }
    int wordCount = Game.getWordCount(intDiff);
    Game newGame = new Game(intDiff, randomGenerator.nextInt(wordCount));
    return newGame;
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
