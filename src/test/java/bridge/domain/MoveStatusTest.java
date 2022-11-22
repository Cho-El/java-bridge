package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveStatusTest {
    @DisplayName("이동 성공 여부에 따른 표기 (O/X/공백) 이 정상적으로 반환되는지 확인한다")
    @ParameterizedTest
    @CsvSource(value = {"true:O", "false:X", "null: "}, delimiter = ':', nullValues = "null", ignoreLeadingAndTrailingWhitespace = false)
    void findMarkByValue(Boolean isSuccess, String mark) {
        assertThat(MoveStatus.findMarkByValue(isSuccess)).isEqualTo(mark);
    }
}