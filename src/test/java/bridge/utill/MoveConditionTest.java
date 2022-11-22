package bridge.utill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveConditionTest {
    @BeforeEach
    void setUp() {
        MoveCondition.initMap();
    }

    @DisplayName("0이면 D 1이면 U을 반환")
    @ParameterizedTest
    @CsvSource(value = {"1/U", "0/D"}, delimiter = '/')
    void correctMatch(int value, String move) {
        assertThat(MoveCondition.getMatchMove(value)).isEqualTo(move);
    }
}