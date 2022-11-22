package bridge.domain;

import bridge.utill.MoveCondition;

import java.util.List;

public class MoveResult {
    private final MySelect upperBridge;
    private final MySelect lowerBridge;

    public MoveResult() {
        upperBridge = new MySelect();
        lowerBridge = new MySelect();
    }

    public void updateMoveResult(boolean isSuccess, String position) {
        if (position.equals(MoveCondition.UP.getMove())) {
            updateEachBridge(isSuccess, null);
        }
        if (position.equals(MoveCondition.DOWN.getMove())) {
            updateEachBridge(null, isSuccess);
        }
    }

    public List<String> getCrossedStatus(String position) {
        if (position.equals(MoveCondition.UP.getMove())) {
            return upperBridge.getMySelect();
        }
        return lowerBridge.getMySelect();
    }

    private void updateEachBridge(Boolean upperResult, Boolean lowerResult) {
        upperBridge.updateMySelect(upperResult);
        lowerBridge.updateMySelect(lowerResult);
    }

    public List<List<String>> getMap() {
        return List.of(upperBridge.getMySelect(), lowerBridge.getMySelect());
    }
}
