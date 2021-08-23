package novi.hangman.exceptions;

public class DuplicateLetterException extends RuntimeException {
    public DuplicateLetterException(char letter) {
        super(String.format("You already tried the letter %s", letter));
    }
}
