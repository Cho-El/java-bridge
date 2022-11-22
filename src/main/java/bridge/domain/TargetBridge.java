package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class TargetBridge {
    private final List<String> targetBridge;
    private final int MAX_SIZE_BRIDGE = 20;
    private final int MIN_SIZE_BRIDGE = 3;

    public TargetBridge(List<String> targetBridge) {
        validBridge(targetBridge);
        this.targetBridge = targetBridge;
    }

    public boolean hasReachedEnd(int index) {
        return index == targetBridge.size();
    }

    private void validBridge(List<String> targetBridge) {
        if (!(targetBridge.size() >= MIN_SIZE_BRIDGE && targetBridge.size() <= MAX_SIZE_BRIDGE)) {
            throw new IllegalArgumentException(Error.NOT_IN_RANGE.getMessage());
        }
    }

    public boolean checkMoveSuccess(String nextPosition, int index) {
        return isNextPositionSame(nextPosition, targetBridge.get(index));
    }

    private boolean isNextPositionSame(String nextPosition, String bridgePosition) {
        return nextPosition.equals(bridgePosition);
    }
}
