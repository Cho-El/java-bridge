package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TargetBridgeTest {

    @DisplayName("3미만 20 초과의 다리가 생성된 경우 오류 발생")
    @Test
    void validTargetBridge() {
        List<String> target1 = List.of("U","D");
        List<String> target2 = List.of("U","U","U","U","U","U","U","U","U","U",
                "U","D","D","D","D","D","D","D","D","D","D","D");
        String HEAD = "[ERROR]";
        assertThatThrownBy(() -> new TargetBridge(target1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.NOT_IN_RANGE.getMessage())
                .hasMessageStartingWith(HEAD);
    }
}