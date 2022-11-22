package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.TargetBridge;
import bridge.view.InputView;

public class GameController {

    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public GameController() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void play() {
        move();
    }

    private void initGame() {
        bridgeGame = new BridgeGame(generateTargetBridge());
    }

    private void move() {
        String nextPosition;
        while (true) {
            try {
                nextPosition = inputView.readMoving();
                bridgeGame.move(nextPosition);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private TargetBridge generateTargetBridge() {
        while (true) {
            try {
                return new TargetBridge(bridgeMaker.makeBridge(inputSize()));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int inputSize() {
        return inputView.readBridgeSize();

    }
}
