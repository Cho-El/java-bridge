package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("이동한 칸의 이동 성공 여부를 계산한다")
    @ParameterizedTest
    @CsvSource(value = {"U:true:0", "D:true:1", "U:false:2", "D:false:3", "U:false:4"}, delimiter = ':')
    void calculateMoveSuccess(String inputPosition, boolean isSuccess, int index) {
        List<String> innerBridge = List.of("U", "D", "D", "U", "D");
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        TargetBridge targetBridge = new TargetBridge(innerBridge);

        assertThat(targetBridge.checkMoveSuccess(inputPosition, index)).isEqualTo(isSuccess);
    }

    @DisplayName("다리를 모두 건넜을 때 게임 종료를 테스트한다")
    @Test
    void checkGameEndWhenReachedEnd() {
        List<String> innerBridge = List.of("U", "D", "D", "U", "D");
        TargetBridge bridge = new TargetBridge(innerBridge);

        int last = innerBridge.size();

        assertThat(bridge.hasReachedEnd(last)).isTrue();
    }

}