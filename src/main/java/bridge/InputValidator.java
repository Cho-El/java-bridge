package bridge;

public class InputValidator {
    private static final String IS_NUMBER_REGEX = "[0-9]+";
    private InputValidator() {
    }

    public static void isNumber(String input) {
        if (!input.matches(IS_NUMBER_REGEX)){
            throw new IllegalArgumentException(Error.NOT_NUMBER.getMessage());
        }
    }
}
