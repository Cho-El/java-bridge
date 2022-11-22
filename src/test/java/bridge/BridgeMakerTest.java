package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @DisplayName("다리 길이만큼 U,D로 이루어진 다리 생성")
    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8})
    void generateBridgeFittedBYLength(int bridgeLength) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        String UP = "U";
        String DOWN = "D";

        assertThat(bridge.size()).isEqualTo(bridgeLength);
        assertThat(bridge).containsOnly(UP, DOWN); // U로만 이루어진 경우 테스트 실패 또는 조건 알아보기
    }
}