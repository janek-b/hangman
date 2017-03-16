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

    while (gameNotOver) {
      System.out.println("\n");
      System.out.println(newGame.getHiddenWord());
      System.out.println("Letters guessed: " + newGame.getLettersGuessed());
      System.out.println("Wrong Guesses: " + newGame.wrongGuesses() + "/" + guessLimit);
      char userGuess = console.readLine("Guess next letter: ").charAt(0);
      System.out.println("-----------------------------");
      newGame.guessLetter(userGuess);


      for (int i = 0; i < newGame.wrongGuesses() * monster.length/guessLimit; i++) {
        System.out.println(monster[i]);
      }

      if (newGame.getHiddenWord().indexOf('_') == -1) {
        System.out.println("\nYou Won!");
        System.out.println("The word was:\t" + newGame.getWord() + "!\n");
        String playAgain = console.readLine("Play again?\n");
        if (playAgain.equals("yes")) {
          newGame = new Game(randomGenerator.nextInt(wordCount));
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

      if (newGame.wrongGuesses() == guessLimit) {
        System.out.println("\nYou Lost!\n");
        System.out.println("The word was:\t" + newGame.getWord() + "!\n");
        String playAgain = console.readLine("Play again?\n");
        if (playAgain.equals("yes")) {
          newGame = new Game(randomGenerator.nextInt(wordCount));
        } else if (playAgain.equals("no")) {
          gameNotOver = false;
        }
      }

    }
  }
}
