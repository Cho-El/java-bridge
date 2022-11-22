package bridge;

import bridge.domain.MoveResult;
import bridge.domain.TargetBridge;
import bridge.utill.MoveCondition;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final TargetBridge targetBridge;
    private final MoveResult moveResult;
    private int currentIdx;

    private boolean isGameOver;

    public BridgeGame(TargetBridge targetBridge) {
        this.targetBridge = targetBridge;
        this.currentIdx = 0;
        this.moveResult = new MoveResult();
        this.isGameOver = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String mySelection) {
        MoveCondition.validMove(mySelection);
        boolean isSuccess = targetBridge.checkMoveSuccess(mySelection, currentIdx); //여기서 연산 하고, bridgeGame 에서 다시 그 결과에 따라 이동 내역 업데이트
        updateCrossedBridge(mySelection, isSuccess);
        updateGameStatus(mySelection, isSuccess);
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isGamePass() {
        return !isGameOver && targetBridge.hasReachedEnd(currentIdx);
    }

    private void updateGameStatus(String mySelection, boolean isSuccess) {
        moveResult.updateMoveResult(isSuccess, mySelection);
        updateGameOverStatus(isSuccess);
        updateBridgeIndex();
    }

    private void updateGameOverStatus(boolean isSuccess) {
        isGameOver = !isSuccess;
    }

    private void updateBridgeIndex() {
        currentIdx += 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initializeGame();
        moveResult.clearResult();
    }

    private void initializeGame() {
        this.currentIdx = 0;
        this.isGameOver = false;
    }

    public List<List<String>> getCurrentMap() {
        return moveResult.getMap();
    }

    private void updateCrossedBridge(String position, boolean isSuccess) {
        moveResult.updateMoveResult(isSuccess, position);
    }
}
