package bridge.utill;

import bridge.domain.Error;

public class InputValidator {
    private static final String IS_NUMBER_REGEX = "[0-9]+";
    private static final String IS_ALPHABET = "[A-Z]+";
    private InputValidator() {
    }

    public static void isUpperCaseAlphabet(String input) {
        if (!input.matches(IS_ALPHABET)) {
            throw new IllegalArgumentException(Error.NOT_UPPER_CASE_ALPHABET.getMessage());
        }
    }

    public static void isNumber(String input) {
        if (!input.matches(IS_NUMBER_REGEX)){
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }
}
