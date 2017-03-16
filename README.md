
## Specs

| behavior | input example | output example |
|--------|----------|----------|
| start a new game | game | game |
| print letters guessed | guess: "a" | guessed: "a" |
| print game word with no guessed letters | no guesses | "_ _ _ _ _" |
| guess a letter and show updated letters guessed | guess: "a" | guessed: "a" |
| guess a letter and reveal letter in word | guess: "a" | "a _ _ _ _" |
| letters cannot be guessed twice | guess: "a" | "a already guessed. Try again" |






class Game
  array of possible words
  string word
  array list letters guessed

  Game()
    generate random int between 0 and length of words array
    set word equal to word at generated index of words array

  guessLetter(char letter)
    add to letters array

  getLettersGuessed()
    return letters Array

  printWord()
    loop over letters in word,
      if letter in array
        print letter
      else
        print underscore
