import java.util.List;
import java.util.ArrayList;

public class Game {
  private String[] allWords = {"apple"};
  private String word;
  private List<Character> lettersGuessed = new ArrayList<Character>();

  public Game(int index) {
    word = allWords[index];
  }

  public void guessLetter(char letter) {
    if (!lettersGuessed.contains(letter)) {
      lettersGuessed.add(letter);
    }
  }

  public List<Character> getLettersGuessed() {
    return lettersGuessed;
  }

  public String getWord() {
    String revealedWord = "";
    for (int i = 0; i < word.length(); i++) {
      if (lettersGuessed.contains(word.charAt(i))) {
        revealedWord += word.charAt(i) + " ";
      } else {
        revealedWord += "_ ";
      }
    }
    return revealedWord.trim();
  }
}
