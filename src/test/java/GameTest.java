import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class GameTest {

  @Test
  public void newGame_instantiatedCorrectly() {
    Game testGame = new Game(0);
    assertEquals(true, testGame instanceof Game);
  }

  @Test
  public void getWord_returnsAnInstanceOfString_true() {
    Game testGame = new Game(0);
    assertEquals(true, testGame.getWord() instanceof String);
  }

  @Test
  public void guessLetter_returnsLettersGuessed() {
    Game testGame = new Game(0);
    List<Character> expectedGuessList = new ArrayList<Character>();
    expectedGuessList.add('a');
    expectedGuessList.add('b');
    testGame.guessLetter('a');
    testGame.guessLetter('b');
    assertEquals(expectedGuessList, testGame.getLettersGuessed());
  }

  @Test
  public void getWord_returnsUnderscoresWhenNoGuesses() {
    Game testGame = new Game(0);
    assertEquals("_ _ _ _ _", testGame.getWord());
  }

  @Test
  public void getWord_revealsLetterWhenGuessed() {
    Game testGame = new Game(0);
    testGame.guessLetter('a');
    assertEquals("a _ _ _ _", testGame.getWord());
  }

  @Test
  public void guessLetter_doesNotAddLetterTwice() {
    Game testGame = new Game(0);
    List<Character> expectedGuessList = new ArrayList<Character>();
    expectedGuessList.add('a');
    testGame.guessLetter('a');
    testGame.guessLetter('a');
    assertEquals(expectedGuessList, testGame.getLettersGuessed());
  }
}
