package level01.exercise02.model;

public class DniCalculator {

    private static final String LETTERS = "TRWAGMYFPDXBNJZSQVHLCKE";

    public char calculateLetter(int dni) {
        if (dni < 0 || dni > 99_999_999) {
            throw new IllegalArgumentException("Invalid DNI number. Must be between 0 and 99,999,999");
        }
        return LETTERS.charAt(dni % 23);
    }
}
