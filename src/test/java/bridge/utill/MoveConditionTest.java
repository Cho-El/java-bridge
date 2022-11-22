package bridge.utill;

import bridge.domain.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @DisplayName("플레이어가 입력한 이동할 칸이 정해진 값이 아니라면 예외가 발생한다")
    @Test
    void createInputWithWrongValue() {
        String inputPosition = "A";
        String Head = "[ERROR]";
        assertThatThrownBy(() -> MoveCondition.validMove(inputPosition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_IN_RANGE_BRIDGE_ALPHABET.getMessage())
                .hasMessageStartingWith(Head);
    }
}