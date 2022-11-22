package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("자연수 이외의 숫자가 들어오는 경우 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a","-","1!"})
    void inputNotNumber(String input) {
        assertThatThrownBy(() -> InputValidator.isNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_NUMBER.getMessage())
                .hasMessageStartingWith(ERROR_HEAD);
    }

    @DisplayName("알파벳 대문자 이외의 문자가 들어오는 경우 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1","ab","","-"})
    void inputNotUpperCase(String input) {
        assertThatThrownBy(() -> InputValidator.isUpperCaseAlphabet(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_UPPER_CASE_ALPHABET.getMessage())
                .hasMessageStartingWith(ERROR_HEAD);
    }
}